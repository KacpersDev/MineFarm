package me.kacperm.ui.renderer.asset;

public enum AssetType {

    PLAYER_FRONT("/images/player/front_player_asset.png"), PLAYER_SIDE("/images/player/side_player_asset.png");

    final String path;

    AssetType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
