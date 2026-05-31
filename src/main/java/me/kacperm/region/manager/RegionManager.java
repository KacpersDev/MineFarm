package me.kacperm.region.manager;

import me.kacperm.player.Player;
import me.kacperm.region.Region;
import me.kacperm.region.impl.Home;

import java.util.HashMap;
import java.util.Map;

public class RegionManager {

    private final Map<String, Region> regions = new HashMap<>();

    public RegionManager() {
        regions.put("home", new Home());
    }

    public Region getRegionByPlayer(Player player) {
        for (Region region : regions.values()) {
            if (region.cuboid().isPlayerInCuboid(player)) {
                return region;
            }
        }

        return null;
    }

    public Map<String, Region> getRegions() {
        return regions;
    }
}
