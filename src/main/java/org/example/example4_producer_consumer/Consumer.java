package org.example.example4_producer_consumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Consumer extends Thread {
    private final Buffer buffer;

    public Consumer (Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 0;

        for (int i = 0; i < 10; i++) {
            value = buffer.get();
            LOGGER.info("Consumer received:\t" + value);
        }
    }
}
