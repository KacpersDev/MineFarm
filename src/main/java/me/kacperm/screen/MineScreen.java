package me.kacperm.screen;

import me.kacperm.Main;
import me.kacperm.screen.screen.GameScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public record MineScreen(Main main, String title, Dimension startingDimension, Dimension minDimension) {

    public void create() {
        JFrame frame = new JFrame(title);
        frame.setLocation(calculateMiddle(Toolkit.getDefaultToolkit().getScreenSize()));
        frame.setSize(new Dimension(startingDimension));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new GameScreen(main));
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                main.getSqLiteManager().createPlayerLocation(main.getGameStorage().getPlayer());
            } 
        });
    }

    private Point calculateMiddle(Dimension playerWindow) {
        if ((startingDimension.width > playerWindow.width) && startingDimension.height > playerWindow.height)
            return new Point(0, 0);

        int centerPlayerWidth = playerWindow.width / 2;
        int centerPlayerHeight = playerWindow.height / 2;

        return new Point(centerPlayerWidth - (startingDimension.width / 2), centerPlayerHeight - (startingDimension.height / 2));
    }
}
