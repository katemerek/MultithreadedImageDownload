package org.example;

import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Download {

    public void downloadPicture(Integer index) throws IOException {
        String pictureName, currentUrl;
        FileOutputStream fileOS;

        currentUrl = DataUrls.getUrls().get(index);
        pictureName = "kotik" + index + ".jpeg";
        InputStream inputStream = new URL(currentUrl).openStream();
        try {
            fileOS = new FileOutputStream("/Users/User/Downloads/kartinki/" + pictureName);
            IOUtils.copy(inputStream, fileOS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
