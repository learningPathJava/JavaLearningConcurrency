package org.example.example4_producer_consumer;

public class Buffer {
    private int number = -1;

    public int get() {
        return number;
    }

    public void put(int number) {
        this.number = number;
    }
}
