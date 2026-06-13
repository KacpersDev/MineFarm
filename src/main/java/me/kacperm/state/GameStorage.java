package me.kacperm.state;

import me.kacperm.Main;
import me.kacperm.player.Player;
import me.kacperm.player.location.Location;

public class GameStorage {

    private final Player player;

    public GameStorage(Main main, String playerName) {
        player = new Player(main, playerName);

        Location playerLocation = main.getSqLiteManager().getPlayerLocation(player);
        if (playerLocation != null) player.setLocation(playerLocation);
    }

    public Player getPlayer() {
        return player;
    }
}
