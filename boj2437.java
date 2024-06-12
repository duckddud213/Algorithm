import java.io.*;
import java.util.*;

public class boj2437 {
    static int N, result;
    static int prefixSum[];
    static int pendulum[];

    public static void Greedy() {
        // 가장 가벼운 추가 1보다 클 경우 무게 1 측정 불가
        if (pendulum[1] != 1) {
            result = 1;
            return;
        }

        prefixSum[1] = pendulum[1];

        int idx = 2;
        while (idx <= N) {
            if (pendulum[idx] > prefixSum[idx - 1] + 1) {
                result = prefixSum[idx - 1] + 1;
                return;
            }
            prefixSum[idx] = prefixSum[idx - 1] + pendulum[idx];
            idx++;
        }
        result = prefixSum[idx - 1] + 1;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        prefixSum = new int[N + 1];
        pendulum = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            pendulum[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pendulum);
    }

    public static void main(String args[]) throws IOException {
        pre();
        Greedy();
        System.out.println(result);
    }
}
