import java.io.*;
import java.util.*;

public class boj20117 {
    static int N, sum;
    static int cow[];

    public static void cal() {
        if (N == 1) {
            sum = cow[0];
        } else {
            for (int i = 0; i < N / 2; i++) {
                sum += (cow[N - 1 - i] * 2);
            }
            if (N % 2 == 1) {
                sum += cow[N / 2];
            }
        }

        System.out.println(sum);
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cow = new int[N];
        sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cow[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cow);
    }

    public static void main(String[] args) throws IOException {
        pre();
        cal();
    }
}
