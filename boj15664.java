import java.io.*;
import java.util.*;

public class boj15664 {
    static int N, M;
    static int input[];
    static int result[];
    static HashMap<String, String> hm;
    static HashMap<Integer, Integer> loc;
    static StringBuilder sb;

    public static void backTracking(int depth, int prev) {
        if (depth == M) {
            makeResult();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!loc.containsKey(i) && prev <= input[i]) {
                result[depth] = input[i];
                loc.put(i, 1);
                backTracking(depth + 1, input[i]);
                loc.remove(i);
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        result = new int[M];
        hm = new HashMap<>();
        loc = new HashMap<>();
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
    }

    public static void makeResult() {
        int i;
        StringBuilder sum = new StringBuilder();
        String output;
        for (i = 0; i < M - 1; i++) {
            sum.append(result[i]).append(" ");
        }
        sum.append(result[i]);
        output = sum.toString();

        if (!hm.containsKey(output)) {
            hm.put(output, output);
            sb.append(output).append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        backTracking(0, 0);
        System.out.print(sb);
    }
}
