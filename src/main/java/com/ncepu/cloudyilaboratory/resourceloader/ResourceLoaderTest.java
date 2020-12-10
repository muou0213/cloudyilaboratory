package com.ncepu.cloudyilaboratory.resourceloader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResourceLoaderTest {
    public static void main(String[] args) throws IOException {
       /* URL url = com.ncepu.cloudyiliboratory.resourceloader.ResourceLoaderTest.class.getClassLoader().getResource("application.properties");
        File file = new File(url.getFile());

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }*/

        InputStream resourceStream =
                ResourceLoaderTest.class.getClassLoader().getResourceAsStream("application.properties");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceStream);
        byte[] bytes = new byte[128];
        while ((bufferedInputStream.read(bytes)) != -1) {
            String s = new String(bytes);
            System.out.println(s);
        }
    }
}
