package me.kacperm;

import me.kacperm.state.GameStorage;
import me.kacperm.screen.MineScreen;
import me.kacperm.screen.renderer.MineRenderer;

import java.awt.*;

public class Main {

    private static final String TITLE = "MineFarm";
    private static final int MIN_WIDTH = 1920, MIN_HEIGHT = 1080;
    private static final int STARTING_WIDTH = 1920, STARTING_HEIGHT = 1080;

    private final MineScreen mineUI = new MineScreen(this, TITLE, new Dimension(STARTING_WIDTH, STARTING_HEIGHT),
            new Dimension(MIN_WIDTH, MIN_HEIGHT));

    private final MineRenderer mineRenderer = new MineRenderer();
    private final GameStorage gameStorage = new GameStorage(this, "KacperM");

    static void main() {
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
}