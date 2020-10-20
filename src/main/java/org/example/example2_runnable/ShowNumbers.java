package org.example.example2_runnable;

public class ShowNumbers implements Runnable {
    private final String name;
    private final int a;
    private final int b;
    private final int step;

    public ShowNumbers(String name, int a, int b, int step) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.step = step;
    }

    @Override
    public void run() {
        for (int i = a; i <= b; i += step) {
            System.out.printf("%s %d%n", name, i);
        }
    }
}
