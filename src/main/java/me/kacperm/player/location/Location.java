package me.kacperm.player.location;

import me.kacperm.world.World;

public class Location {

    private World world;
    private int x, y;
    private Direction direction;

    public Location(World world, int x, int y) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.direction = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
