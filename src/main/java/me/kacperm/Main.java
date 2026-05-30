package me.kacperm;

import me.kacperm.ui.MineUI;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static final String TITLE = "";
    private static final int MIN_WIDTH = 1920, MIN_HEIGHT = 1080;
    private static final int STARTING_WIDTH = 1920, STARTING_HEIGHT = 1080;

    private final static MineUI mineUI = new MineUI(TITLE, new Dimension(STARTING_WIDTH, STARTING_HEIGHT),
            new Dimension(MIN_WIDTH, MIN_HEIGHT));

    static void main() {
        mineUI.create();
    }
}