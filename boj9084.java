import java.io.*;
import java.util.*;

public class boj9084 {
    static int x, T, N, M;
    static int coin[], money[];
    static StringBuilder sb;

    public static void backpack() {
        for (int i = 0; i < N; i++) {
            money[coin[i]]++;
            for (int j = coin[i]; j <= M; j++) {
                money[j] += money[j - coin[i]];
            }
        }
        sb.append(money[M]).append('\n');
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (x = 0; x < T; x++) {
            N = Integer.parseInt(br.readLine());
            coin = new int[N];
            money = new int[10001];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            
            M = Integer.parseInt(br.readLine());
            backpack();
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
