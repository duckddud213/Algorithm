import java.io.*;
import java.util.*;
 
public class Main {
    static final int INF = 987654321;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
        int[][] dist = new int[N + 1][N + 1]; // 원래 주어진 배열
        int[][] arr = new int[N + 1][N + 1]; // 플로이드 와샬 알고리즘 수행 전 배열
        boolean[][] check = new boolean[N + 1][N + 1];
 
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = dist[i][j];
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    
                    if (i == j || i == k || k == j) {
                        continue;
                    }
                    
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        bw.write("-1\n");
                        bw.flush();
                        bw.close();
                        br.close();
                        return;
                    }
                    
                    if (dist[i][j] == dist[i][k] + dist[k][j]) {
                        arr[i][j] = INF;
                    }
                }
            }
        }
 
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != INF && i != j && !check[i][j]) {
                    ans += arr[i][j];
                    check[i][j] = check[j][i] = true;
                }
            }
        }
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}
