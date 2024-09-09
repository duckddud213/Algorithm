import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int parents[], rank[];
    static HashMap<String, Integer> map;
    static StringBuilder sb;

    public static int find(int x) {
        if (parents[x] == x)
            return x;
        int rx = find(parents[x]);
        return rx;
    }

    public static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x > y) {
                parents[x] = y;
                rank[y] += rank[x];
                return rank[y];
            }
            else {
                parents[y] = x;
                rank[x] += rank[y];
            }
        }
        return rank[x];
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        sb = new StringBuilder();

        for (int x = 1; x <= T; x++) {
            int friend = Integer.parseInt(br.readLine());

            parents = new int[2 * 100001];
            rank = new int[2 * 100001];
            for (int i = 1; i < 2 * 100001; i++) {
                parents[i] = i;
                rank[i] = 1;
            }

            int idx = 1;
            for (int i = 0; i < friend; i++) {
                String line = br.readLine();
                st = new StringTokenizer(line);
                for (int j = 0; j < 2; j++) {
                    String name = st.nextToken();
                    if (!map.containsKey(name)) {
                        map.put(name, idx++);
                    }
                }

                String[] network = line.split(" ");
                int to = map.get(network[0]);
                int from = map.get(network[1]);
                int num = union(to, from);
                sb.append(num + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        pre();
        System.out.println(sb);
    }
}