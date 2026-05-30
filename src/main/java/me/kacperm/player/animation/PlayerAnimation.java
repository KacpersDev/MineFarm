package me.kacperm.player.animation;

import me.kacperm.Main;
import me.kacperm.player.Player;
import me.kacperm.player.location.Direction;
import me.kacperm.ui.renderer.asset.AssetType;

import java.awt.*;

public class PlayerAnimation {

    private final Main main;
    private final Player player;

    private Image currentImage;

    private final Image frontPlayer;
    private final Image sidePlayer;

    private int sx1 = 0, sy1 = 0, sx2 = 50, sy2 = 50;

    public PlayerAnimation(Main main, Player player) {
        this.main = main;
        this.player = player;

        this.frontPlayer = main.getMineRenderer().render(AssetType.PLAYER_FRONT);
        this.sidePlayer = main.getMineRenderer().render(AssetType.PLAYER_SIDE);

        this.currentImage = frontPlayer;
    }

    public void updateAnimation() {
        player.setAnimTick(player.getAnimTick() + 1);
        if (player.getAnimTick() >= 16) player.setAnimTick(0);

        if (player.getLocation().getDirection() == null) {
            currentImage = frontPlayer;
            sx1 = 0;
            sy1 = 0;
            sx2 = 50;
            sy2 = 50;
            return;
        }

        switch (player.getLocation().getDirection()) {
            case EAST -> {
                currentImage = sidePlayer;

                int frame = player.getAnimTick() / 8;

                sx1 = frame * 50;
                sy1 = 50;
                sx2 = sx1 + 50;
                sy2 = sy1 + 45;
            }
        }
    }

    public void resetAnimation() {
        player.getLocation().setDirection(null);
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public int getSx1() {
        return sx1;
    }

    public int getSx2() {
        return sx2;
    }

    public int getSy1() {
        return sy1;
    }

    public int getSy2() {
        return sy2;
    }
}