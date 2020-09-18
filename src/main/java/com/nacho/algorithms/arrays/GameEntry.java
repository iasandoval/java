package com.nacho.algorithms.arrays;

/**
 * Class that represents a Game entry in a Scoreboard.
 *
 * @author iasandoval
 */
public class GameEntry {

    /**
     * Name of the person
     */
    private String name;

    /**
     * Score value.
     */
    private int score;

    /**
     * Constructor
     *
     * @param name  Name of the person
     * @param score Score value
     */
    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "GameEntry [name=" + name + ", score=" + score + "]";
    }
}
