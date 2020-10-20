package org.example.example2_thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadRunner implements Runnable {

    private final String name;

    public ThreadRunner(String name) {
        this.name = name;
    }

    public void run() {
        try {
            for(int i=0; i<5; i++) {
                LOGGER.info("Running " + name + " ... " + i);
                Thread.sleep((1000));
            }
        } catch (InterruptedException e) {
            // e.printStackTrace()

            // InterruptedException when an another thread interrupts this thread
            LOGGER.error("Interrupted!", e);
            // Restore interrupted state...
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Run in Main and Run in different threads
     *
     * First we execute the run() methods in sequence
     * Then we execute them in different threads
     */
    public static void main(String[] args) {

        LOGGER.info("Both 'threads' run in main thread");
        ThreadRunner tr1 = new ThreadRunner("Thread 1");
        ThreadRunner tr2 = new ThreadRunner("Thread 2");
        tr1.run();
        tr2.run();

        LOGGER.info("Both 'threads' run in different thread");
        Thread tr3 = new Thread(new ThreadRunner("Thread 1"));
        Thread tr4 = new Thread(new ThreadRunner("Thread 2"));
        tr3.start();  //invokes run() method from Runnable
        tr4.start();

        LOGGER.info("End of program (will end before Thread 1 and Thread 2)");
    }
}
