import java.io.*;
import java.util.*;

public class boj10162 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        sb.append(T / 300).append(" ");
        T %= 300;

        sb.append(T / 60).append(" ");
        T %= 60;

        sb.append(T / 10);
        T %= 10;

        if (T != 0) {
            sb = new StringBuilder();
            sb.append("-1");
        }

        System.out.println(sb);
    }
}
