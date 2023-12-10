import java.io.*;
import java.util.*;

public class boj1068 {
    static int N, num,root,cnt;
    static int parent[];
    static boolean isVisited[];
    static HashSet<Integer> nodeNum;

    public static void removeNode() {
        int tmp;

        tmp = nodeNum.size();

        parent[num] = Integer.MIN_VALUE;

        while (tmp != 0) {
            tmp = 0;
            for (int i = 0; i < N; i++) {
                if (nodeNum.contains(parent[i])) {
                    tmp++;
                    nodeNum.add(i);
                    parent[i] = Integer.MIN_VALUE;
                }
            }
        }
    }
    
    public static void countLeaf(int idx) {
        if (parent[idx] == Integer.MIN_VALUE) {
            return;
        }

        isVisited[idx] = true;
        boolean isLeaf = true;

        for (int i = 0; i < N; i++) {
            if (parent[i] == idx && !isVisited[i]) {
                countLeaf(i);
                isLeaf = false;
            }
        }

        if (isLeaf) {
            cnt++;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = 0;

        parent = new int[N];
        isVisited = new boolean[N];
        nodeNum = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) {
                root = i;
            }
        }

        num = Integer.parseInt(br.readLine());
        nodeNum.add(num);
    }

    public static void main(String args[]) throws IOException{
        pre();
        removeNode();
        countLeaf(root);
        System.out.println(cnt);
    }
}
