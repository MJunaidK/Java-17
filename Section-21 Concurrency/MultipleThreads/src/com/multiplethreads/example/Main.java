package com.multiplethreads.example;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        StopWatch greenWatch = new StopWatch(TimeUnit.SECONDS);
        StopWatch purpleWatch = new StopWatch(TimeUnit.SECONDS);
        StopWatch redWatch = new StopWatch(TimeUnit.SECONDS);
        Thread green = new Thread(greenWatch::countDown, dev.lpa.ThreadColor.ANSI_GREEN.name());
        Thread purple = new Thread(() -> purpleWatch.countDown(7),
                dev.lpa.ThreadColor.ANSI_PURPLE.name());
        Thread red = new Thread(redWatch::countDown, dev.lpa.ThreadColor.ANSI_RED.name());
        green.start();
        purple.start();
        red.start();
    }
}

class StopWatch {

    private TimeUnit timeUnit;
    private int i;

    public StopWatch(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void countDown() {
        countDown(5);
    }

    public void countDown(int unitCount) {

        String threadName = Thread.currentThread().getName();

        dev.lpa.ThreadColor threadColor = dev.lpa.ThreadColor.ANSI_RESET;
        try {
            threadColor = dev.lpa.ThreadColor.valueOf(threadName);
        } catch (IllegalArgumentException ignore) {
            // User may pass a bad color name, Will just ignore this error.
        }
        String color = threadColor.color();
        for (i = unitCount; i > 0; i--) {
            try {
                timeUnit.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s%s Thread : i = %d%n", color, threadName, i);
        }
    }
}
