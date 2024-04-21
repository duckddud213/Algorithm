import java.io.*;
import java.util.*;

public class boj15666 {
    static int N, M;
    static HashSet<Integer> isUsed;
    static List<Integer> num;
    static Deque<Integer> isSelected;
    static StringBuilder sb;

    public static void backTracking(int depth) {
        if (depth == M) {
            for (int next : isSelected) {
                sb.append(next).append(" ");
            }
            sb.append('\n');
            return;
        }
        
        for (int i = 0; i < num.size(); i++) {
            if (depth == 0) {
                isSelected.add(num.get(i));
                backTracking(depth + 1);
                isSelected.removeLast();
            }
            else if (isSelected.peekLast() <= num.get(i)) {
                isSelected.add(num.get(i));
                backTracking(depth + 1);
                isSelected.removeLast();
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        num = new ArrayList<>();
        isUsed = new HashSet<>();
        isSelected = new ArrayDeque<>();
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (!isUsed.contains(input)) {
                isUsed.add(input);
                num.add(input);
            }
        }

        Collections.sort(num);
    }

    public static void main(String args[]) throws IOException {
        pre();
        backTracking(0);
        System.out.print(sb);
    }
}
