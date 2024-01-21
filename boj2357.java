import java.io.*;
import java.util.*;

public class boj2357 {
    static int N, M, H, treesize, min, max;
    static int element[], mintree[], maxtree[];
    static StringBuilder sb;

    public static void init(int type, int tree[], int src, int dest, int node) {
        if (src == dest) {
            tree[node] = element[src];
        } else {
            int mid = (src + dest) / 2;
            init(type, tree, src, mid, node * 2);
            init(type, tree, mid + 1, dest, node * 2 + 1);

            if (type == 0) {
                if (tree[node * 2] < tree[node * 2 + 1]) {
                    tree[node] = tree[node * 2];
                } else {
                    tree[node] = tree[node * 2 + 1];
                }
            } else {
                if (tree[node * 2] > tree[node * 2 + 1]) {
                    tree[node] = tree[node * 2];
                } else {
                    tree[node] = tree[node * 2 + 1];
                }
            }
        }
    }
    
    public static void query(int type, int tree[], int src, int dest, int node, int left, int right) {
        if (left > dest || right < src) {
            return;
        }
		if(left <= src && dest <= right) {
            if (type == 0) {
                min = Math.min(min, tree[node]);
            } 
            else {
                max = Math.max(max, tree[node]);
			}
			return;
		}

        int mid = (src + dest) / 2;
        query(type, tree, src, mid, node * 2, left, right);
        query(type, tree, mid + 1, dest, node * 2 + 1, left, right);
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = (int) Math.ceil(Math.log(N) / Math.log(2));
        treesize = (int) Math.pow(2, H + 1);
        element = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            element[i] = Integer.parseInt(br.readLine());
        }

        mintree = new int[treesize];
        maxtree = new int[treesize];
        init(0, mintree, 1, N, 1);
        init(1, maxtree, 1, N, 1);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            min = 1000000001;
            max = -1;

            query(0, mintree, 1, N, 1, a, b);
            query(1, maxtree, 1, N, 1, a, b);
			sb.append(min+" "+max+"\n");
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
