package com.nacho.algorithms.analysis;

/**
 * Class to store the number of executions and the time taken.
 * 
 * @author iasandoval
 *
 */
public class TimeResult {

    // Number of times of executions
    private int number;
    // Time in milliseconds
    private long timer;

    /**
     * Default constructor.
     * 
     * @param number Number of times of executions.
     * @param timer Time in milliseconds.
     */
    public TimeResult(int number, long timer) {
	this.number = number;
	this.timer = timer;
    }

    /**
     * Get the number of times of executions
     * 
     * @return The number of times of executions
     */
    public int getNumber() {
	return number;
    }

    /**
     * Set the number of times of executions
     * 
     * @param number The number of times of executions
     */
    public void setNumber(int number) {
	this.number = number;
    }

    /**
     * Get the Time in milliseconds
     * @return The time in milliseconds
     */
    public long getTimer() {
	return timer;
    }

    /**
     * Set the Time in milliseconds
     * @param timer The time in milliseconds
     */
    public void setTimer(long timer) {
	this.timer = timer;
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "TimeResult [number=" + number + ", timer=" + timer + "]";
    }

}
