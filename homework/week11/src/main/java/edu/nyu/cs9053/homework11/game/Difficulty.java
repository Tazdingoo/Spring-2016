package edu.nyu.cs9053.homework11.game;

/**
 * User: blangel
 * Date: 11/15/15
 * Time: 3:36 PM
 */
public enum Difficulty {

    Easy(1),

    Medium(2),

    Hard(3);

    private final int level;

    private Difficulty(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
