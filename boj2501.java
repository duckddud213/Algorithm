import java.io.*;
import java.util.*;

public class boj2501 {
    public static void main(String args[]) throws IOException {
        int i, N, K, cnt, result;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = 0;
        result = 0;

        for (i = 1; i <= N; i++) {
            if (N % i == 0) {
                cnt++;
            }
            if (cnt == K) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
