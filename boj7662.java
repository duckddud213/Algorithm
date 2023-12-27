import java.io.*;
import java.util.*;

public class boj7662 {
    static int x, T, K, num;
    static String cal;
    static StringBuilder sb;
    static TreeMap<Integer, Integer> map;

    public static void doCal() {
        int n;
        if (cal.equals("D")) {
            if (map.size() == 0) {
                return;
            }
            if (num == 1) {
                n = map.lastKey();
            } 
            else {
                n = map.firstKey();
            }
            if (map.put(n, map.get(n) - 1) == 1) {
                map.remove(n);
            }
        } 
        else {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        map = new TreeMap<>();

        T = Integer.parseInt(br.readLine());
        for (int x = 1; x <= T; x++) {
            K = Integer.parseInt(br.readLine());
            map.clear();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                cal = st.nextToken();
                num = Integer.parseInt(st.nextToken());
                doCal();
            }
            sb.append(map.size() == 0 ? "EMPTY" : map.lastKey() + " " + map.firstKey()).append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
