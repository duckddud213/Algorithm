import java.io.*;
import java.util.*;

public class boj20055 {
    static int N, K, cnt, proc;
    static int belt[];
    static boolean robot[];

    public static void process() {
        int i, tmp;
        proc = 1;
        cnt = 0;
        while (cnt < K) {
            // 1번

            tmp = belt[2 * N];
            for (i = 2 * N; i >= 2; i--) {
                belt[i] = belt[i - 1];
            }
            belt[1] = tmp;

            for (i = N; i >= 2; i--) {
                robot[i] = robot[i - 1];
            }
            robot[1] = false;

            // 2번
            robot[N] = false;
            for (i = N - 1; i >= 1; i--) {
                if (!robot[i + 1] && robot[i] && belt[i + 1] >= 1) {// 다음 칸으로 이동 가능한 경우
                    robot[i + 1] = robot[i];
                    robot[i] = false;
                    belt[i + 1]--;
                    if (belt[i + 1] <= 0) {
                        cnt++;
                    }
                }
            }

            // 3번
            if (belt[1] >= 1) {
                robot[1] = true;
                belt[1]--;
                if (belt[1] <= 0) {
                    cnt++;
                }
            }

            // 4번
            // for (i = 1; i <= 2 * N; i++) {
            // if (belt[i] <= 0) {
            // cnt++;
            // }
            // }

            if (cnt >= K) {
                break;
            }

            proc++;
        }
    }

    public static void pre() throws IOException {
        int i, j;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2 * N + 1];
        robot = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (i = 1; i <= 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        process();
        System.out.println(proc);
    }
}
