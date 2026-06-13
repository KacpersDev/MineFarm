package me.kacperm.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import me.kacperm.Main;
import me.kacperm.player.Player;
import me.kacperm.player.location.Location;
import me.kacperm.world.World;

public class SQLiteManager {

    private final Main main;
    private final String databasePath = "jdbc:sqlite:/Users/kacper/IdeaProjects/MineFarm/minefarm.db";

    public SQLiteManager(Main main) {
        this.main = main;

        init();
    }
    
    private void init() {
        try (Connection connection = DriverManager.getConnection(databasePath)) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS player(name varchar(16) PRIMARY KEY, world varchar(16), x INT, y INT)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPlayerLocation(Player player) {
        try (Connection connection = DriverManager.getConnection(databasePath)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO player(name, world, x, y) VALUES (?,?,?,?) ON CONFLICT(name) DO UPDATE SET world = ?, x = ?, y = ?")) {
                preparedStatement.setString(1, player.getName());
                preparedStatement.setString(2, player.getLocation().getWorld().name());
                preparedStatement.setInt(3, player.getLocation().getX());
                preparedStatement.setInt(4, player.getLocation().getY());
                preparedStatement.setString(5, player.getLocation().getWorld().name());
                preparedStatement.setInt(6, player.getLocation().getX());
                preparedStatement.setInt(7, player.getLocation().getY());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Location getPlayerLocation(Player player) {
        try (Connection connection = DriverManager.getConnection(databasePath)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM player WHERE name = ?")) {
                preparedStatement.setString(1, player.getName());
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int x = resultSet.getInt("x"); 
                        int y = resultSet.getInt("y");
                        World world = this.main.getWorldManager().getWorlds().get(resultSet.getString("world"));
                        Location location = new Location(world, x, y);
                        return location;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
