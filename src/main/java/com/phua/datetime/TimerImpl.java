package com.phua.datetime;

import java.time.Duration;
import java.time.Instant;

interface Timer{

    default void printTime(long duration) {
        System.out.println(duration);
    }

    default Duration getDuration(Instant start, Instant finish){
        return Duration.between(start, finish);
    }

}

public class TimerImpl implements Timer {

    private Instant start;
    private Instant finish;

    public void start() {
        start = Instant.now();
    }

    public void stop() {
        finish = Instant.now();
    }

    public long getNanos() {
        long duration = getDuration(start, finish).toNanos();
        printTime(duration);
        return duration;
    }

    public long getMilis() {
        long duration = getDuration(start, finish).toMillis();
        printTime(duration);
        return duration;
    }


    public long getSeconds() {
        long duration = getDuration(start, finish).toSeconds();
        printTime(duration);
        return duration;
    }

    public long getMinutes() {
        long duration = getDuration(start, finish).toMinutes();
        printTime(duration);
        return duration;
    }



}
