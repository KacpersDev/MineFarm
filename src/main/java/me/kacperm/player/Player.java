package me.kacperm.player;

import me.kacperm.Main;
import me.kacperm.player.animation.PlayerAnimation;
import me.kacperm.player.location.Direction;
import me.kacperm.player.location.Location;
import me.kacperm.region.Region;

public class Player {

    private final Main main;
    private final String name;

    private Location location;

    private final PlayerAnimation playerAnimation;

    private int health;
    private int foodLevel;
    private int sleepLevel;

    private int animTick = 0;

    private int screenWidth;
    private int screenHeight;

    private boolean corner = true;

    public Player(Main main, String name) {
        this.main = main;
        this.name = name;
        this.location = new Location(main.getWorldManager().getDefault(), 0,0);

        this.health = 20;
        this.foodLevel = 20;

        this.playerAnimation = new PlayerAnimation(main, this);
    }

    public void move(int x, int y, Direction direction) {
        switch (direction) {
            case EAST -> {
                if (location.getX() + x > screenWidth - 100) {
                    location.setX(screenWidth - 100);
                    location.setDirection(Direction.EAST);
                    return;
                }

                location.setX(location.getX() + x);
                location.setY(location.getY() + y);
                location.setDirection(Direction.EAST);
            }
            case SOUTH -> {
                if (location.getY() + y >= screenHeight - 150) {
                    location.setY(screenHeight - 150);
                    location.setDirection(Direction.SOUTH);
                    return;
                }

                location.setX(location.getX() + x);
                location.setY(location.getY() + y);
                location.setDirection(Direction.SOUTH);
            }
            case NORTH -> {
                if (location.getY() + y <= 0) {
                    location.setY(0);
                    location.setDirection(Direction.NORTH);
                    return;
                }

                location.setX(location.getX() + x);
                location.setY(location.getY() + y);
                location.setDirection(Direction.NORTH);
            }
            case WEST -> {
                if (location.getX() - x <= 0) {
                    location.setX(0);
                    location.setDirection(Direction.WEST);
                    return;
                }

                location.setX(location.getX() + x);
                location.setY(location.getY() + y);
                location.setDirection(Direction.WEST);
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getFoodLevel() {
        return foodLevel;
    }

    public int getHealth() {
        return health;
    }

    public Location getLocation() {
        return location;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setFoodLevel(int foodLevel) {
        this.foodLevel = foodLevel;
    }

    public int getAnimTick() {
        return animTick;
    }

    public void setAnimTick(int animTick) {
        this.animTick = animTick;
    }

    public PlayerAnimation getPlayerAnimation() {
        return playerAnimation;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public Region getCurrentRegion() {
        return main.getRegionManager().getRegionByPlayer(this);
    }

    public void setCorner(boolean corner) {
        this.corner = corner;
    }

    public boolean isCorner() {
        return corner;
    }
}
