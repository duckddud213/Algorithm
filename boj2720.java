import java.io.*;
import java.util.*;

public class boj2720 {
    static int x, T, change;
    static StringBuilder sb;
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (x = 1; x <= T; x++) {
            change = Integer.parseInt(br.readLine());

            sb.append(change / 25).append(" ");
            change %= 25;

            sb.append(change / 10).append(" ");
            change %= 10;

            sb.append(change / 5).append(" ");
            change %= 5;

            sb.append(change / 1).append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
