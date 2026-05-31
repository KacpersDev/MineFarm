package me.kacperm.screen.renderer;

import me.kacperm.assets.AssetValues;
import me.kacperm.player.Player;
import me.kacperm.region.Region;
import me.kacperm.screen.renderer.asset.AssetType;

import javax.swing.*;
import java.awt.*;

public class MineRenderer {

    public Image render(AssetType type) {
        return new ImageIcon(getClass().getResource(type.getPath())).getImage();
    }

    public void renderScreenImage(Graphics g, Image image, int x, int y) {
        g.drawImage(image, x, y, null);
    }

    public void renderPlayer(Player player, Graphics g) {
        g.drawImage(player.getPlayerAnimation().getCurrentImage(), player.getLocation().getX(), player.getLocation().getY(),
                player.getLocation().getX() + AssetValues.PLAYER_CHARACTER[0], player.getLocation().getY() + AssetValues.PLAYER_CHARACTER[1],
                player.getPlayerAnimation().getSx1(), player.getPlayerAnimation().getSy1(), player.getPlayerAnimation().getSx2(), player.getPlayerAnimation().getSy2(), null);
    }

    public void renderPlayerCorner(Player player, Graphics g) {
        g.setColor(Color.white);
        g.setFont(Font.getFont("Arial"));

        Region region = player.getCurrentRegion();
        String regionName = region == null ? "None" : region.name();

        int rightCornerX = player.getScreenWidth() - 120;
        int rightCornerY = 20;

        g.drawString("Location: " + player.getLocation().getX() + ", " + player.getLocation().getY(), rightCornerX, rightCornerY);
        g.drawString("Region: " + regionName, rightCornerX, rightCornerY + 20);
        g.drawString("Hide with (P)", rightCornerX, rightCornerY + 40);
    }
}
