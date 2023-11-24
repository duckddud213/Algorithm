import java.io.*;
import java.util.*;

public class boj12904 {
    static String src;
    static String dest;

    public static void cal() {

        while (src.length() > dest.length()) {
            if (src.charAt(src.length() - 1) == 'A') {
                src = src.substring(0, src.length() - 1);
            } else {
                src = src.substring(0, src.length() - 1);
                StringBuilder sb = new StringBuilder(src);
                src = sb.reverse().toString();
            }
        }

        System.out.println(src.equals(dest) ? 1 : 0);
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dest = br.readLine();
        src = br.readLine();
    }

    public static void main(String[] args) throws IOException {
        pre();
        cal();
    }
}
