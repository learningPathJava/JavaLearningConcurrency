package org.example.example5_monitor;

/**
 * Monitor = "lock" associated with each object
 */
public class Buffer {
    private int number = -1;

    public synchronized int get() {
        // buffer blocked by producer
        return number;
        // buffer unlocked by the producer
    }

    public synchronized void put(int number) {
        // buffer blocked by consumer
        this.number = number;
        // buffer unlocked by the consumer
    }
}
