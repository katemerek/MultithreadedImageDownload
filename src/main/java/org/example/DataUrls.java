package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public final class DataUrls {
    ArrayList<String> urls;

    public ArrayList<String> getUrls() { //получаем все урлы
        String fileName = "/Users/User/Desktop/CatsUrls.txt";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            urls = (ArrayList<String>) br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urls;//возвращаем список с урлами для дальенейшего использования
    }


}

