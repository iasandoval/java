package com.nacho.algorithms.analysis;

/**
 * Class to store the number of executions and the time taken.
 *
 * @author iasandoval
 */
public class TimeResult {

    // Number of times of executions
    private final int number;
    // Time in milliseconds
    private final long timer;

    /**
     * Default constructor.
     *
     * @param number Number of times of executions.
     * @param timer  Time in milliseconds.
     */
    public TimeResult(int number, long timer) {
        this.number = number;
        this.timer = timer;
    }

    @Override
    public String toString() {
        return "TimeResult{number=" + number + ", timer=" + timer + '}';
    }
}
