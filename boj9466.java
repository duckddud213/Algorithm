import java.io.*;
import java.util.*;

public class boj9466 {
    static int x, T, N, cnt;
    static int team[];
    static boolean isJoined[], isChecked[];
    static StringBuilder sb;

    public static void dfs(int num) {
        if (isChecked[num]) {
            isJoined[num] = true;
            cnt++;
        }
        else {
            isChecked[num] = true;
        }

        if (!isJoined[team[num]]) {
            dfs(team[num]);
        }

        isChecked[num] = false;
        isJoined[num] = true;
    }
    
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int x = 1; x <= T; x++) {
            N = Integer.parseInt(br.readLine());
            cnt = 0;

            team = new int[N + 1];
            isJoined = new boolean[N + 1];
            isChecked = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int member = Integer.parseInt(st.nextToken());
                team[i] = member;
                if (i == member) {
                    isJoined[i] = true;
                    cnt++;
                }
            }

            for (int i = 1; i <= N; i++) {
                if (!isJoined[i]) {
                    dfs(i);
                }
            }
            sb.append(N - cnt).append('\n');
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}
