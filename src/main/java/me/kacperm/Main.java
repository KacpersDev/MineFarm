package me.kacperm;

import me.kacperm.region.manager.RegionManager;
import me.kacperm.state.GameStorage;
import me.kacperm.screen.MineScreen;
import me.kacperm.screen.renderer.MineRenderer;
import me.kacperm.sql.SQLiteManager;
import me.kacperm.world.manager.WorldManager;

import java.awt.*;

public class Main {

    private static final String TITLE = "MineFarm";
    private static final int MIN_WIDTH = 1920, MIN_HEIGHT = 1080;
    private static final int STARTING_WIDTH = 1920, STARTING_HEIGHT = 1080;

    private final MineScreen mineUI = new MineScreen(this, TITLE, new Dimension(STARTING_WIDTH, STARTING_HEIGHT), new Dimension(MIN_WIDTH, MIN_HEIGHT));

    private final WorldManager worldManager = new WorldManager();
    private final RegionManager regionManager = new RegionManager();
    private final MineRenderer mineRenderer = new MineRenderer();
    private final SQLiteManager sqLiteManager = new SQLiteManager(this);
    private final GameStorage gameStorage = new GameStorage(this, "KacperM");

    public static void main(String[] args) {
        Main main = new Main();
        main.mineUI.create();
    }

    public MineRenderer getMineRenderer() {
        return mineRenderer;
    }

    public GameStorage getGameStorage() {
        return gameStorage;
    }

    public static int getMinHeight() {
        return MIN_HEIGHT;
    }

    public static int getMinWidth() {
        return MIN_WIDTH;
    }

    public RegionManager getRegionManager() {
        return regionManager;
    }

    public WorldManager getWorldManager() {
        return worldManager;
    }

    public SQLiteManager getSqLiteManager() {
        return sqLiteManager;
    }
}