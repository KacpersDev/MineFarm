package me.kacperm.ui.screen;

import me.kacperm.Main;
import me.kacperm.player.Player;
import me.kacperm.player.location.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements KeyListener {

    private final Main main;
    private final Player player;

    public Screen(Main main) {
        this.main = main;

        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        player = main.getGameStorage().getPlayer();

        SwingUtilities.invokeLater(this::requestFocusInWindow);

        Timer timer = new Timer(16, e -> {
            update();
            repaint();
        });

        timer.start();
    }

    private void update() {
        player.getPlayerAnimation().updateAnimation();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        main.getMineRenderer().renderPlayer(player, g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D -> player.move(10,0, Direction.EAST);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.getPlayerAnimation().resetAnimation();
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}