package me.kacperm.screen.screen;

import me.kacperm.Main;
import me.kacperm.assets.AssetValues;
import me.kacperm.player.Player;
import me.kacperm.player.location.Direction;
import me.kacperm.player.location.Location;
import me.kacperm.region.Region;
import me.kacperm.screen.renderer.asset.AssetType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends JPanel implements KeyListener {

    private final Main main;
    private final Player player;

    public GameScreen(Main main) {
        this.main = main;

        setFocusable(true);
        addKeyListener(this);
        setLayout(null);

        player = main.getGameStorage().getPlayer();
        player.setScreenWidth(Main.getMinWidth());
        player.setScreenHeight(Main.getMinHeight());

        SwingUtilities.invokeLater(this::requestFocusInWindow);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component component = e.getComponent();
                player.setScreenWidth((int) component.getSize().getWidth());
                player.setScreenHeight((int) component.getSize().getHeight());

                Location playerLocation = player.getLocation();
                if (playerLocation.getX() > player.getScreenWidth() - 100) {
                    playerLocation.setX(player.getScreenWidth() - 100);
                }
            }
        });

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

        int x = 0;
        for (int i = -50; i < 40; i++) {
            for (int y = -10; y < 25; y++) {
                main.getMineRenderer().renderScreenImage(g, main.getMineRenderer().render(AssetType.GRASS), x, y * 50);
            }
            x += 105;
        }

        main.getMineRenderer().renderPlayer(player, g);

        Region region = main.getRegionManager().getRegionByPlayer(player);

        if (player.isCorner()) {
            main.getMineRenderer().renderPlayerCorner(player, g);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> player.move(0, -AssetValues.PLAYER_SPEED, Direction.NORTH);
            case KeyEvent.VK_D -> player.move(AssetValues.PLAYER_SPEED,0, Direction.EAST);
            case KeyEvent.VK_S -> player.move(0, AssetValues.PLAYER_SPEED, Direction.SOUTH);
            case KeyEvent.VK_A -> player.move(-AssetValues.PLAYER_SPEED, 0, Direction.WEST);
            case KeyEvent.VK_P -> player.setCorner(!player.isCorner());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.getPlayerAnimation().resetAnimation();
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}