import java.io.*;

public class boj2798 {
    public static void backTracking(int N, int M, int depth, int sum[], int card[], int use[]) {
        int i, j;

        for (i = 0; i < N; i++) {
            for (j = 0; j < depth; j++) {
                if (card[i] == use[j]) {
                    j += N;
                }
            }

            if (j == depth) {
                use[depth] = card[i];
            } else {
                continue;
            }

            if (depth == 2) {
                int cardSum = use[0] + use[1] + use[2];
                if ((cardSum <= M) && (cardSum > sum[0])) {
                    sum[0] = cardSum;
                }
            } else {
                backTracking(N, M, depth + 1, sum, card, use);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int N, M;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String inp[] = br.readLine().split(" ");

        N = Integer.parseInt(inp[0]);
        M = Integer.parseInt(inp[1]);

        int card[] = new int[N];
        int use[] = new int[3];
        int sum[] = new int[1];

        inp = br.readLine().split(" ");
        sum[0] = 0;

        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(inp[i]);
        }

        backTracking(N, M, 0, sum, card, use);

        System.out.println(sum[0]);
    }

}
