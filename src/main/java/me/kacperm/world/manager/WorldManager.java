package me.kacperm.world.manager;

import me.kacperm.world.World;

import java.util.HashMap;
import java.util.Map;

public class WorldManager {

    private final Map<String, World> worlds = new HashMap<>();

    public WorldManager() {
        worlds.put("world", () -> "world");
    }

    public World getDefault() {
        return worlds.get("world");
    }

    public Map<String, World> getWorlds() {
        return worlds;
    }
}
