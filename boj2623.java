import java.io.*;
import java.util.*;

public class boj2623 {
    static int N, M;
    static StringBuilder sb;
    static int enterLine[];
    static int order[];
    static HashSet<Integer> direction[];
    static PriorityQueue<Integer> showOrder;

    public static void TopologicalSort() {
        int i, cnt;

        for (i = 1; i <= N; i++) {
            if (enterLine[i] == 0) {
                showOrder.add(i);
            }
        }
        cnt = 0;

        while (!showOrder.isEmpty()) {
            cnt++;
            int num = showOrder.poll();
            sb.append(num).append('\n');

            Iterator<Integer> it = direction[num].iterator();
            while (it.hasNext()) {
                int next = it.next();
                enterLine[next]--;
                if (enterLine[next] == 0) {
                    showOrder.add(next);
                }
            }

        }

        if (cnt != N) {
            // 모든 순서대로 출력되지 않은 경우
            sb = new StringBuilder();
            sb.append("0");
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        enterLine = new int[N + 1];
        direction = new HashSet[N + 1];
        showOrder = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            direction[i] = new HashSet<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            order = new int[num];
            for (int j = 0; j < num; j++) {
                order[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < num - 1; j++) {
                if (!direction[order[j]].contains(order[j + 1])) {
                    direction[order[j]].add(order[j + 1]);
                    enterLine[order[j + 1]]++;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        TopologicalSort();
        System.out.println(sb);
    }
}
