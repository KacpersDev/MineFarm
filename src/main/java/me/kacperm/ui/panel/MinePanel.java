package me.kacperm.ui.panel;

import me.kacperm.assets.AssetValues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MinePanel extends JPanel implements KeyListener {

    private int x = 100, y = 100;

    private boolean up, down, left, right;

    private final Image frontPlayer;
    private final Image sidePlayer;

    private Image currentImage;

    private int sx1 = 0, sy1 = 0, sx2 = 50, sy2 = 50;

    private int animTick = 0;

    public MinePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        frontPlayer = new ImageIcon(getClass().getResource("/images/player/front_player_asset.png")).getImage();
        sidePlayer = new ImageIcon(getClass().getResource("/images/player/side_player_asset.png")).getImage();

        currentImage = frontPlayer;

        SwingUtilities.invokeLater(this::requestFocusInWindow);

        Timer timer = new Timer(16, e -> {
            update();
            repaint();
        });

        timer.start();
    }

    private void update() {
        handleMovement();
        updateAnimation();
    }

    private void handleMovement() {
        int speed = AssetValues.PLAYER_SPEED;

        if (up) y -= speed;
        if (down) y += speed;
        if (left) x -= speed;
        if (right) x += speed;
    }

    private void updateAnimation() {
        animTick++;
        if (animTick >= 16) animTick = 0;

        if (right) {
            currentImage = sidePlayer;

            int frame = animTick / 8;

            sx1 = frame * 50;
            sy1 = 50;
            sx2 = sx1 + 50;
            sy2 = sy1 + 45;
        } else {
            currentImage = frontPlayer;

            sx1 = 0;
            sy1 = 0;
            sx2 = 50;
            sy2 = 50;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(currentImage, x, y, x + AssetValues.PLAYER_CHARACTER[0], y + AssetValues.PLAYER_CHARACTER[1],
                sx1, sy1, sx2, sy2,
                null
        );
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> up = true;
            case KeyEvent.VK_S -> down = true;
            case KeyEvent.VK_A -> left = true;
            case KeyEvent.VK_D -> right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> up = false;
            case KeyEvent.VK_S -> down = false;
            case KeyEvent.VK_A -> left = false;
            case KeyEvent.VK_D -> right = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}