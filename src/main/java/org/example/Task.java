package org.example;

import java.io.IOException;
import java.time.LocalTime;

public class Task implements Runnable {
    private Integer index;

    public Task(Integer index) {
        this.index = index;
    }


    @Override
    public void run() {
        LocalTime now = LocalTime.now();
        System.out.println("Task " + index + " Time: " + now + " Thread: " + Thread.currentThread().getName());
        try {
            Download download = new Download();
            download.downloadPicture(index);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


