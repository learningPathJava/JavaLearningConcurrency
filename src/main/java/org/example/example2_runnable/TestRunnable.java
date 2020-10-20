package org.example.example2_runnable;

/**
 * Implement Runnable ver.1
 */
public class TestRunnable {
    public static void main(String[] args) {
        ShowNumbers showNumbers = new ShowNumbers("Task 1: ", 0, 100, 10);
        Thread thread1 = new Thread(showNumbers);
        thread1.start();
    }
}
