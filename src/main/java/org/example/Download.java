package org.example;

import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;

public class Download {
    private DataUrls dataUrls;

    public Download(DataUrls dataUrls) {//передаем текущий экземпляр класса, НЕ создаем новый
        this.dataUrls = dataUrls;
    }

    public void downloadPicture(Integer index) throws IOException {
        String pictureName, currentUrl;
        FileOutputStream fileOS;

        currentUrl = this.dataUrls.urls.get(index);//один и тот же индекс
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
