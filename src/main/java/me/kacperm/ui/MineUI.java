package me.kacperm.ui;

import me.kacperm.Main;
import me.kacperm.ui.screen.Screen;

import javax.swing.*;
import java.awt.*;

public record MineUI(Main main, String title, Dimension startingDimension, Dimension minDimension) {

    public void create() {
        JFrame frame = new JFrame(title);
        frame.setMinimumSize(minDimension);
        frame.setSize(startingDimension);
        frame.setLocation(calculateMiddle(Toolkit.getDefaultToolkit().getScreenSize()));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new Screen(main));
        frame.setVisible(true);
    }

    private Point calculateMiddle(Dimension playerWindow) {
        if ((startingDimension.width > playerWindow.width) && startingDimension.height > playerWindow.height)
            return new Point(0, 0);

        int centerPlayerWidth = playerWindow.width / 2;
        int centerPlayerHeight = playerWindow.height / 2;

        return new Point(centerPlayerWidth - (startingDimension.width / 2), centerPlayerHeight - (startingDimension.height / 2));
    }
}
