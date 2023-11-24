import java.io.*;
import java.util.*;

public class boj14889 {
    static int N, diff;
    static int stat[][];
    static boolean teamLink[];
    static int isUsed[];
    static int memberA[];
    static int memberB[];

    public static void backTracking(int depth) {
        int i, j, idx, sumA, sumB;

        if (depth == N / 2) {
            i = 0;
            j = 0;
            sumA = 0;
            sumB = 0;
            for (idx = 1; idx <= N; idx++) {
                if (teamLink[idx]) {
                    memberA[i] = idx;
                    i++;
                } else {
                    memberB[j] = idx;
                    j++;
                }
            }

            for (i = 0; i < N / 2; i++) {
                for (j = i + 1; j < N / 2; j++) {
                    sumA += (stat[memberA[i] - 1][memberA[j] - 1] + stat[memberA[j] - 1][memberA[i] - 1]);
                    sumB += (stat[memberB[i] - 1][memberB[j] - 1] + stat[memberB[j] - 1][memberB[i] - 1]);
                }
            }

            if (diff > Math.abs(sumA - sumB)) {
                diff = Math.abs(sumA - sumB);
            }

            return;
        }

        for (i = 1; i <= N; i++) {
            for (j = 0; j < depth; j++) {
                if (isUsed[j] >= i) { // ���� ���¸� �ð��ʰ��� ������ ���� ���·� ���� üũ
                    break;
                }
            }

            if (j != depth) {
                continue;
            }

            teamLink[i] = true; // ��� ��ȣ�� �ε����� �ϴ� teamLink �迭 ���
            isUsed[depth] = i;
            backTracking(depth + 1);
            teamLink[i] = false;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stat = new int[N][N];
        teamLink = new boolean[N + 1];
        memberA = new int[N / 2];
        memberB = new int[N / 2];
        isUsed = new int[N / 2];
        diff = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        backTracking(0);
        System.out.println(diff);
    }
}