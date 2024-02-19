import java.io.*;
import java.util.*;

public class boj5063 {
    static StringBuilder sb;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (b - c > a) {
                sb.append("advertise").append('\n');
            } else if (b - c == a) {
                sb.append("does not matter").append('\n');
            } else {
                sb.append("do not advertise").append('\n');
            }
        }
        System.out.println(sb);
    }
}
