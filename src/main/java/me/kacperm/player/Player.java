package me.kacperm.player;

import me.kacperm.Main;
import me.kacperm.player.animation.PlayerAnimation;
import me.kacperm.player.location.Direction;
import me.kacperm.player.location.Location;

public class Player {

    private final String name;
    private final Location location;

    private final PlayerAnimation playerAnimation;

    private int health;
    private int foodLevel;

    private int animTick = 0;

    public Player(Main main, String name) {
        this.name = name;
        this.location = new Location("world", 0,0);

        this.health = 20;
        this.foodLevel = 20;

        this.playerAnimation = new PlayerAnimation(main, this);
    }

    public void move(int x, int y, Direction direction) {
        switch (direction) {
            case EAST -> {
                location.setX(location.getX() + x);
                location.setY(location.getY() + y);
                location.setDirection(Direction.EAST);
            }
            case SOUTH -> {
                location.setX(location.getX() + x);
                location.setY(location.getY() + y);
                location.setDirection(Direction.SOUTH);
            }
            case NORTH -> {
                location.setX(location.getX() + x);
                location.setY(location.getY() + y);
                location.setDirection(Direction.NORTH);
            }
            case WEST -> {
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
}
