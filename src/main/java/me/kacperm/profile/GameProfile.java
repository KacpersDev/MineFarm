package me.kacperm.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class GameProfile {

    private UUID uuid;
    private String username;
    private String email;
    private String password;
}
