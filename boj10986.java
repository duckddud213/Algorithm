import java.io.*;
import java.util.*;

public class boj10986 {
    static int N, M;
    static long result;
    static long num[], cnt[];

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;

        num = new long[N + 1];
        cnt = new long[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            num[i] = (num[i - 1] + Integer.parseInt(st.nextToken())) % M;

            if (num[i] == 0) {
                result++;
            }

            cnt[(int) num[i]]++;
        }

        for (int i = 0; i < M; i++) {
            if (cnt[i] > 1) {
                result += (cnt[i] * (cnt[i] - 1) / 2);
            }
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(result);
    }
}
