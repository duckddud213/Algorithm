import java.io.*;
import java.util.*;

public class boj2212 {
    static int N, K, sum;
    static int sensor[];
    static int diff[];

    public static void cal() {
        Arrays.sort(sensor);

        if (N <= K) { // 센서보다 기지국 수가 많거나 같은 경우 = 길이의 합 0(1:1 매칭)
            System.out.println(0);
        } else {
            for (int i = 1; i < N; i++) {
                diff[i - 1] = sensor[i] - sensor[i - 1];
            }
            Arrays.sort(diff);

            for (int i = 0; i < N - K; i++) {
                sum += diff[i];
            }
            System.out.println(sum);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        sensor = new int[N];
        diff = new int[N - 1];
        sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        cal();

    }
}
