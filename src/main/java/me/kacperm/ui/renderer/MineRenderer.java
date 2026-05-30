package me.kacperm.ui.renderer;

import me.kacperm.assets.AssetValues;
import me.kacperm.player.Player;
import me.kacperm.ui.renderer.asset.AssetType;

import javax.swing.*;
import java.awt.*;

public class MineRenderer {

    public Image render(AssetType type) {
        return new ImageIcon(getClass().getResource(type.getPath())).getImage();
    }

    public void renderPlayer(Player player, Graphics g) {
        g.drawImage(player.getPlayerAnimation().getCurrentImage(), player.getLocation().getX(), player.getLocation().getY(),
                player.getLocation().getX() + AssetValues.PLAYER_CHARACTER[0], player.getLocation().getY() + AssetValues.PLAYER_CHARACTER[1],
                player.getPlayerAnimation().getSx1(), player.getPlayerAnimation().getSy1(), player.getPlayerAnimation().getSx2(), player.getPlayerAnimation().getSy2(), null);
    }
}
