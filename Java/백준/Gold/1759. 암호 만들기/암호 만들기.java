import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char alpha[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    static HashSet<Integer> hset;
    static List<Integer> code;
    static StringBuilder sb;

    public static void backTracking(int idx, int depth, int cnt, String pw) {
        if (depth == L) {
            if (cnt < 1 || L - cnt < 2) {
                return;
            }

            sb.append(pw).append("\n");
            return;
        }

        for (int i = idx; i < C; i++) {
            char next = alpha[code.get(i)];
            int num = cnt;

            if (hset.contains(code.get(i))) {
                num++;
            }

            backTracking(i + 1, depth + 1, num, pw + Character.toString(next));
        }
    }

    public static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        hset = new HashSet<>();
        code = new ArrayList<>();
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            char next = st.nextToken().charAt(0);

            code.add(next - 'a');
        }
        hset.add(0);
        hset.add(4);
        hset.add(8);
        hset.add(14);
        hset.add(20);

        Collections.sort(code);
    }

    public static void main(String args[]) throws IOException {
        inputs();
        backTracking(0, 0, 0, "");
        System.out.print(sb);
    }
}
