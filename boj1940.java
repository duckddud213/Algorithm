
import java.io.*;
import java.util.Arrays;

public class boj1940 {
    public static void main(String[] args) throws IOException {
        int N, M, i, cnt, src, dest, sum, add;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String inp[] = br.readLine().split(" ");

        int num[] = new int[N];

        for (i = 0; i < N; i++) {
            num[i] = Integer.parseInt(inp[i]);
        }

        Arrays.sort(num);

        cnt = 0;
        src = 0;
        dest = N - 1;
        sum = num[src] + num[dest];

        while (src < dest) {
            if (sum >= M) {
                if (sum == M) {
                    cnt++;
                    src++;
                }
                dest--;
            } else {
                src++;
            }
            sum = num[src] + num[dest];
        }

        System.out.println(cnt);
    }
}