import java.io.*;
import java.util.*;

public class boj9093 {
    static int x, T;
    static StringBuilder sb;
    public static void reverseString(String input) {
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        for (int x = 1; x <= T; x++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String cur = st.nextToken();
                reverseString(cur);
                sb.append(" ");
            }
            sb.append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}