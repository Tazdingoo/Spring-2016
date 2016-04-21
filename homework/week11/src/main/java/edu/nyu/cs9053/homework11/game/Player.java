package edu.nyu.cs9053.homework11.game;

import net.ocheyedan.Emoji;

/**
 * User: blangel
 * Date: 11/15/15
 * Time: 11:24 AM
 */
public class Player {

    private final Emoji emoji;

    public Player(Emoji emoji) {
        this.emoji = emoji;
    }

    public Emoji getEmoji() {
        return emoji;
    }
}
