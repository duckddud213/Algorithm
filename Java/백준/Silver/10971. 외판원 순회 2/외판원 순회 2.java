import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long result;
    static boolean isVisited[];
    static int road[][];

    public static void backtracking(int depth, long sum, int prev, int src) {
        if (depth == N) {
            if(road[prev][src]==0){
                return;
            }
            result = Math.min(result, sum + road[prev][src]);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) {
                continue;
            }

            if (prev == -1) {
                src = i;
            }
            else if(road[prev][i] == 0){
                //갈 수 없는 경우
                continue;
            }

            int add = prev == -1 ? 0 : road[prev][i];
            isVisited[i] = true;
            backtracking(depth + 1, sum + add, i, src);
            isVisited[i] = false;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        result = Long.MAX_VALUE;

        isVisited = new boolean[N];
        road = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        backtracking(0, 0, -1, -1);
        System.out.println(result);
    }
}