package me.kacperm.profile;

import me.kacperm.profile.control.Control;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Profile {

    private final UUID uuid;
    private final String username;
    private final String password;

    private final Map<Control, Integer> controls = new HashMap<>();

    public Profile(UUID uuid, String username, String password) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public Map<Control, Integer> getControls() {
        return controls;
    }

    public UUID getUuid() {
        return uuid;
    }
}
