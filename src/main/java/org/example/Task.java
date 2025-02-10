package org.example;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Task implements Runnable {
    private Integer index;//этот индекс пойдет в другой класс
    private Download download;

    public Task(Integer index, DataUrls dataUrls) {
        this.index = index;//передаем в конструкторе чтоб другие могли его использовать
        this.download = new Download(dataUrls);
    }

    @SneakyThrows
    @Override
    public void run() {
        LocalTime now = LocalTime.now();
        System.out.println("Task " + this.index + " Time: " + now + " Thread: " + Thread.currentThread().getName());
        this.download.downloadPicture(this.index);//исп.текущий индекс, не новый каждый раз
        if (index % 2 == 0) Thread.sleep(5000);
    }
}


