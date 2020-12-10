import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        /*System.out.println(Integer.numberOfLeadingZeros(16));
        int i = resizeStamp(16);
        i = i << 16;
        i = i + 2;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);*/


        List<String> VALID_SERVICES =
                Collections.unmodifiableList(Arrays.asList("git-upload-pack", "git-receive-pack"));
        StringBuilder url = new StringBuilder();
        url.append("^(?:/p/|/)(.*/(?:info/refs");
        for (String name : VALID_SERVICES) {
            url.append('|').append(name);
        }
        url.append("))$");
        System.out.println(url.toString());

        Executors.newScheduledThreadPool(1);


    }

    static final int resizeStamp(int n) {
        int i = 1;
        Integer a = 2;
        synchronized(a) {

        }
        return Integer.numberOfLeadingZeros(n) | (1 << 15);
    }
}
