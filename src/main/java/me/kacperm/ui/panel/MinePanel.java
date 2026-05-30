package me.kacperm.ui.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MinePanel extends JPanel implements KeyListener {

    private int x = 100, y = 100;
    private boolean up = false, down = false, left = false, right = false;

    public MinePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        SwingUtilities.invokeLater(this::requestFocusInWindow);

        Timer timer = new Timer(16, e -> update());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillOval(x,y, 100, 100);
    }

    private void update() {
        int speed = 4;

        if (up) y -= speed;
        if (down) y+= speed;
        if (left) x -= speed;
        if (right) x+= speed;

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            up = true;
        } else if (e.getKeyChar() == 's') {
            down = true;
        } else if (e.getKeyChar() == 'd') {
            right = true;
        } else if (e.getKeyChar() == 'a') {
            left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            up = false;
        } else if (e.getKeyChar() == 's') {
            down = false;
        } else if (e.getKeyChar() == 'd') {
            right = false;
        } else if (e.getKeyChar() == 'a') {
            left = false;
        }
    }
}
