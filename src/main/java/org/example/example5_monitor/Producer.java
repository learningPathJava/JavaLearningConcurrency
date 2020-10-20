package org.example.example5_monitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Producer extends Thread {

    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            processSomething(i);
            LOGGER.info("Producer say:\t" + i);
        }
    }

    private void processSomething(int value) {
        // processing some job
        try {
            Thread.sleep(1);
            buffer.put(value);
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted!", e);
            Thread.currentThread().interrupt();
        }
    }
}
