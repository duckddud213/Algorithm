import java.io.*;
import java.util.*;

public class boj13023 {
    static int N, M;
    static boolean hasFriend;
    static List<Integer> connection[];
    static boolean checked[];

    public static void dfs(int num,int depth) {
        if (depth == 4) {
            hasFriend = true;
            return;
        }
        // System.out.println(num+" "+depth);

        for (int i = 0; i < connection[num].size(); i++) {
            if (!checked[connection[num].get(i)]) {
                checked[connection[num].get(i)] = true;
                dfs(connection[num].get(i), depth + 1);
                checked[connection[num].get(i)] = false;
            }
        }

    }
    
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        hasFriend = false;

        connection = new List[N];

        for (i = 0; i < N; i++) {
            connection[i] = new ArrayList<>();
        }

        for (i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            connection[a].add(b);
            connection[b].add(a);
        }

        i=0;
        while (!hasFriend && i < N) {
            checked = new boolean[N];
            checked[i] = true;
            dfs(i,0);
            i++;
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(hasFriend ? 1 : 0);
    }
}
