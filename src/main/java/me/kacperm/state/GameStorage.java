package me.kacperm.state;

import me.kacperm.Main;
import me.kacperm.player.Player;

public class GameStorage {

    private final Player player;

    public GameStorage(Main main, String playerName) {
        player = new Player(main, playerName);
    }

    public Player getPlayer() {
        return player;
    }
}
