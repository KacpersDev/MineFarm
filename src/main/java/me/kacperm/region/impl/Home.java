package me.kacperm.region.impl;

import me.kacperm.cuboid.Cuboid;
import me.kacperm.region.Region;

public class Home implements Region {

    @Override
    public String name() {
        return "Home";
    }

    @Override
    public Cuboid cuboid() {
        return new Cuboid(0,0,100,100);
    }

    @Override
    public boolean safezone() {
        return true;
    }
}
