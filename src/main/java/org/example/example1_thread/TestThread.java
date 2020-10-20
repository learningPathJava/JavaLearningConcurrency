package org.example.example1_thread;

/**
 * Extending the Thread class
 */
public class TestThread {
    public static void main(String[] args) {
        ShowNumbers thread1;
        thread1 = new ShowNumbers("Thread 1:", 0, 100, 10);
        // count from 0 to 100 with step 10

        ShowNumbers thread2;
        thread2 = new ShowNumbers("Thread 2:", 100, 200, 10);
        // count from 100 to 200 with step 5

        thread1.start();
        thread2.start();
        // the threads will be automatically destroyed upon completion
    }
}
