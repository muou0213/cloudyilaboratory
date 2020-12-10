package com.ncepu.cloudyilaboratory.messageresource;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageResourceLoaderTest {

    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("my", new Locale("zh", "CN"));
        String cancel = bundle.getString("cancelKey");
        System.out.println(cancel);

        bundle = ResourceBundle.getBundle("my", Locale.US);
        cancel = bundle.getString("cancelKey");
        System.out.println(cancel);

        bundle = ResourceBundle.getBundle("my", Locale.getDefault());
        cancel = bundle.getString("cancelKey");
        System.out.println(cancel);

        bundle = ResourceBundle.getBundle("my", Locale.GERMAN);
        cancel = bundle.getString("cancelKey");
        System.out.println(cancel);
        bundle = ResourceBundle.getBundle("my");
        for (String key : bundle.keySet()) {
            System.out.println(bundle.getString(key));
        }
    }
}
