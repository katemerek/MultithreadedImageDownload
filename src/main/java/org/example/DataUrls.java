package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class DataUrls {
    private static List<String> urls = new ArrayList <> ();

    public static List<String> getUrls() {
        String fileLocation = "/Users/User/Desktop/CatsUrls.txt";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileLocation))) {
            urls = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urls;
    }


}

