package me.kacperm.region;

import me.kacperm.cuboid.Cuboid;

public interface Region {

    String name();
    Cuboid cuboid();
    boolean safezone();
}
