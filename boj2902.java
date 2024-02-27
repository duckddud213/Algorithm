import java.io.*;
import java.util.*;

public class boj2902 {
    static String input;
    static StringBuilder sb;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                sb.append(input.charAt(i));
            }
        }

        System.out.println(sb);
    }
}
