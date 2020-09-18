package com.nacho.algorithms.arrays;

/**
 * Class that represents a scoreboard.
 *
 * @author iasandoval
 */
public class Scoreboard {

    private int numEntries = 0;
    private GameEntry[] board;

    /**
     * Constructor to initialize the scoreboard.
     *
     * @param boardSize The board size.
     */
    public Scoreboard(int boardSize) {
        this.board = new GameEntry[boardSize];
    }

    /**
     * Add a new Game entry if it is high enough.
     *
     * @param entry A GameEntry to add to the scoreboard.
     */
    public void add(GameEntry entry) {
        int newScore = entry.getScore();

        // It is a high score?
        if (this.hasBoardSpace() || newScore > this.board[this.numEntries - 1].getScore()) {
            // If the board has space, increment the num. of entries
            if (this.hasBoardSpace()) {
                this.numEntries++;
            }

            // Move any lower score, to make room for the new entry
            int i = numEntries - 1;
            while (i > 0 && this.board[i - 1].getScore() < newScore) {
                // Shift entry
                this.board[i] = this.board[i - 1];
                i--;
            }
            // When done, add new entry
            this.board[i] = entry;

        }

    }


    public GameEntry remove(int i) {
        return null;
    }

    /**
     * Check if the scoreboard has space available.
     *
     * @return TRUE, if the scoreboard has space.
     */
    private boolean hasBoardSpace() {
        return this.numEntries < this.board.length;
    }

    /**
     * @return the numEntries
     */
    public int getNumEntries() {
        return numEntries;
    }
}
