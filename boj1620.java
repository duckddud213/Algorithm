import java.io.*;
import java.util.*;

public class boj1620 {
    static int N, M;
    static StringBuilder sb;
    static HashMap<String, Integer> pocketmon1;
    static HashMap<Integer, String> pocketmon2;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        pocketmon1 = new HashMap<>();
        pocketmon2 = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String input;
        sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            input = br.readLine();
            pocketmon1.put(input, i);
            pocketmon2.put(i, input);
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine();

            if (input.charAt(0) >= 49 && input.charAt(0) <= 57) {
                sb.append(pocketmon2.get(Integer.parseInt(input))).append('\n');
            }
            else {
                sb.append(pocketmon1.get(input)).append('\n');
            }
        }

    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
