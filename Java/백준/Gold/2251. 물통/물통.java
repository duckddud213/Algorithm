import java.io.*;
import java.util.*;

public class Main {
    static int cap[];
    static boolean check[][];
    static TreeSet<Integer> result;
    static StringBuilder sb;

    public static void waterMove(int a, int b, int c) {
        if (check[a][b])
            return;

        if (a == 0) {
            result.add(c);
        }
        check[a][b] = true;
        // 0 -> 1
        if (a + b > cap[1]) {
            waterMove((a + b) - cap[1], cap[1], c);
        }
        else {
            waterMove(0, a + b, c);
        }

        // 1 -> 0
        if (a + b > cap[0]) {
            waterMove(cap[0], a + b - cap[0], c);
        }
        else {
            waterMove(a + b, 0, c);
        }

        // 2 -> 0
        if (a + c > cap[0]) {
            waterMove(cap[0], b, a + c - cap[0]);
        }
        else {
            waterMove(a + c, b, 0);
        }

        // 2 -> 1
        if (b + c > cap[1]) {
            waterMove(a, cap[1], b + c - cap[1]);
        }
        else {
            waterMove(a, b + c, 0);
        }

        // 0 -> 2
        waterMove(a, 0, b + c);
        // 1 -> 2
        waterMove(0, b, a + c);
    }

    public static void makeResult() {
        for (int num : result) {
            sb.append(num).append(" ");
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cap = new int[3];
        check = new boolean[201][201];
        result = new TreeSet<>();
        sb = new StringBuilder();

        cap[0] = Integer.parseInt(st.nextToken());
        cap[1] = Integer.parseInt(st.nextToken());
        cap[2] = Integer.parseInt(st.nextToken());
    }

    public static void main(String args[]) throws IOException {
        pre();
        waterMove(0, 0, cap[2]);
        makeResult();
        System.out.println(sb);
    }
}