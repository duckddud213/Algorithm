import java.io.*;
import java.util.*;

public class boj10810 {
    public static void main(String args[]) throws IOException {
        int N, M;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int bucket[] = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int j = a; j <= b; j++) {
                bucket[j] = c;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(bucket[i]+" ");
        }
    }
}
