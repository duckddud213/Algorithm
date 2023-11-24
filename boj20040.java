import java.io.*;
import java.util.*;

public class boj20040 {
    static int N, M,result;
    static int parent[];

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (a > b) {
            parent[a] = b;
        }
        else {
            parent[b] = a;
        }
    }
    
    public static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static boolean isUnion(int x, int y) {
        if (find(x) == find(y)) {
            return true;
        }
        return false;
    }

    public static void pre() throws IOException {
        int i,a,b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        result = 0;

        for (i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (result == 0) {
                if (isUnion(a, b)) {//result == 0 이면서 같은 루트 => 사이클 형성
                    result = i;
                }
                else {
                    union(a, b);
                }
            }
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(result);
    }
}
