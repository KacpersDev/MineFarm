package me.kacperm.ui;

import lombok.Data;
import me.kacperm.ui.panel.MinePanel;

import javax.swing.*;
import java.awt.*;

@Data
public class MineUI {

    private String title;
    private Dimension startingDimension;
    private Dimension minDimension;
    private boolean running = false;

    public MineUI(String title, Dimension startingDimension, Dimension minDimension) {
        this.title = title;
        this.startingDimension = startingDimension;
        this.minDimension = minDimension;
    }

    public void create() {
        JFrame frame = new JFrame(title);
        frame.setMinimumSize(minDimension);
        frame.setSize(startingDimension);
        frame.setLocation(calculateMiddle(Toolkit.getDefaultToolkit().getScreenSize()));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new MinePanel());
        frame.setVisible(true);

        running = true;
    }

    private Point calculateMiddle(Dimension playerWindow) {
        if ((startingDimension.width > playerWindow.width) && startingDimension.height > playerWindow.height) return new Point(0,0);

        int centerPlayerWidth = playerWindow.width / 2;
        int centerPlayerHeight = playerWindow.height / 2;

        return new Point(centerPlayerWidth - (startingDimension.width / 2), centerPlayerHeight - (startingDimension.height / 2));
    }
}
