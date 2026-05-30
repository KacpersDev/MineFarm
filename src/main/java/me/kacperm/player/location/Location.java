package me.kacperm.player.location;

public class Location {

    private String world;
    private int x, y;
    private Direction direction;

    public Location(String world, int x, int y) {
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

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
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
