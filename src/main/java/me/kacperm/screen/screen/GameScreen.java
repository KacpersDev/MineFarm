package me.kacperm.screen.screen;

import me.kacperm.Main;
import me.kacperm.assets.AssetValues;
import me.kacperm.player.Player;
import me.kacperm.player.location.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends JPanel implements KeyListener {

    private final Main main;
    private final Player player;

    public GameScreen(Main main) {
        this.main = main;

        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        setLayout(null);

        player = main.getGameStorage().getPlayer();
        player.setScreenWidth(Main.getMinWidth());
        player.setScreenHeight(Main.getMinHeight());

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
            case KeyEvent.VK_W -> player.move(0, -AssetValues.PLAYER_SPEED, Direction.NORTH);
            case KeyEvent.VK_D -> player.move(AssetValues.PLAYER_SPEED,0, Direction.EAST);
            case KeyEvent.VK_S -> player.move(0, AssetValues.PLAYER_SPEED, Direction.SOUTH);
            case KeyEvent.VK_A -> player.move(-AssetValues.PLAYER_SPEED, 0, Direction.WEST);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.getPlayerAnimation().resetAnimation();
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}