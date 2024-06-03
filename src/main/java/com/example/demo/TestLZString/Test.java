package com.example.demo.TestLZString;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Test {
  /*  public static void main(String[] args) throws IOException, InterruptedException {
        String url = "http://s3-us-west-1.amazonaws.com/sdpcs-prod-awsca/88ea9001-bad0-4b46-86e5-e6bc518c9fdc?Expires=1718171230&response-content-type=image/jpeg&response-cache-control=max-age%3D157680000&AWSAccessKeyId=AKIAI7P7PYLVYWVVYTLQ&Signature=iCeE6%2FIHtxmOarOc3Q1hUowWqDc%3D";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);

        for (int i = 0; i < 100000; i++) {
            httpClient.execute(request, response -> {
                String content = EntityUtils.toString(response.getEntity());
                System.out.println(content);
                return content;
            });

            Thread.sleep(23000);
        }
    }*/


    public static void main(String[] args) throws IOException {
        String fileName = "D:/1128-1-1.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String s = IOUtils.toString(br);
        String deompress = LZStringUtil.decompressFromUTF16(s);
        System.out.println(deompress);

    }

}
