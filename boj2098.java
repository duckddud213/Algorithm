import java.io.*;
import java.util.*;

public class boj2098 {
    static int N, INF;
    static int cost[][];
    static int dp[][];

    public static int TSP(int loc, int checkBit) {
        if (checkBit == (1 << N) - 1) { // 모든 도시 방문 완료 시
            if (cost[loc][0] == 0) {
                return INF;
            } 
            else {
                return cost[loc][0];
            }
        }

        if (dp[loc][checkBit] != -1) {
            return dp[loc][checkBit];
        }

        dp[loc][checkBit] = INF;

        for (int i = 0; i < N; i++) {
            if (cost[loc][i] == 0 || (checkBit & (1 << i)) != 0) {
                continue;
            } 
            else {
                dp[loc][checkBit] = Math.min(dp[loc][checkBit], TSP(i, checkBit | (1 << i)) + cost[loc][i]);
            }
        }

        return dp[loc][checkBit];
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        INF = (N * N * 1000000) + 1;

        cost = new int[N][N];
        dp = new int[N][(1 << N) - 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(TSP(0,1));
    }
}
