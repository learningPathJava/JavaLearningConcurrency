package org.example.example4_producer_consumer;

import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@Slf4j
public class Producer extends Thread {

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.put(i);
            LOGGER.info("Producer say:\t" + i);

            try {
                Random rand = SecureRandom.getInstanceStrong();
                int randValue = rand.nextInt(100);
                sleep(randValue);
            } catch (InterruptedException | NoSuchAlgorithmException e) {
                LOGGER.error("Interrupted!", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
