package org.example.example2_runnable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecuteThread implements Runnable {
    private Thread thread = null;

    public ExecuteThread() {
        thread = new Thread(this);
    }

    @Override
    public void run() {
        LOGGER.info("Run thread: " + thread.getName());
    }
}

/**
 * Implement Runnable ver.2
 */
class TestExecuteThread {
    public static void main(String[] args) {
        ExecuteThread thread = new ExecuteThread();
        thread.run();
    }
}
