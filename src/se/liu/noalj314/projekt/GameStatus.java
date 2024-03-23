package se.liu.noalj314.projekt;

/**
 * The GameStatus enum represents the current status of the game.
 * It can be MENU, indicating the game is in the menu state, or PLAYING, indicating the game is in progress.
 */
public enum GameStatus
{
    MENU, PLAYING;
    /**
     * The current status of the game. This field is mutable because the game status changes
     * from MENU to PLAYING when the game starts, and potentially to other statuses in the future.
     */
    public static GameStatus gameStatus = MENU;
}
