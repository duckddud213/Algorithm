import java.io.*;
import java.util.*;

public class boj13458 {
    public static void main(String args[]) throws IOException {
        int N, B, C;
        long sum;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int A[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sum = 0;

        for (int i = 0; i < N; i++) {
            sum++;
            A[i] -= B;
            if (A[i] < 0) {
                continue;
            }
            if (A[i] % C == 0) {
                sum += (A[i] / C);
            } else {
                sum += (A[i] / C) + 1;
            }
        }

        System.out.println(sum);
    }
}
