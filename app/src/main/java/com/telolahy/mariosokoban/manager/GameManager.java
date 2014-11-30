package com.telolahy.mariosokoban.manager;

/**
 * Created by stephanohuguestelolahy on 11/25/14.
 */
public class GameManager {

    private static final GameManager INSTANCE = new GameManager();

    public static GameManager getInstance() {
        return INSTANCE;
    }

    public int maxLevelReached() {

        return 20;
    }

    public int displayedLevelsCount() {
        return 34;
    }

    public int totalLevelsCount() {
        return 34;
    }

    public boolean isOnLastLevel() {
        return maxLevelReached() >= totalLevelsCount();
    }

    public int retriesForLevel(int level) {
        return 1;
    }

    public void incrementRetriesForLevel(int level) {

    }
}
