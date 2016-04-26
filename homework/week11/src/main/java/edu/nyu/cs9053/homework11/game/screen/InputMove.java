package edu.nyu.cs9053.homework11.game.screen;

/**
 * User: blangel
 * Date: 11/15/15
 * Time: 12:56 PM
 */
public enum InputMove {

    Up,

    Down,

    Right,

    Left;

    public static InputMove getMove(int character) {
        if (character == 65) {
            return Up;
        } else if (character == 66) {
            return Down;
        } else if (character == 67) {
            return Right;
        } else if (character == 68) {
            return Left;
        }
        return null;
    }

}
