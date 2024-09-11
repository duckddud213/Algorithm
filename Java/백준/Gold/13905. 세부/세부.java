import java.io.*;
import java.util.*;

public class Main {
    static int N, M, S, E, max;
    static PriorityQueue<Bridge> road;
    static HashSet<Integer> isVisited;
    static List<Bridge> connection[];

    public static void Prims() {
        while (!road.isEmpty()) {
            Bridge cur = road.poll();

            if (isVisited.contains(S) && isVisited.contains(E)) {
                break;
            }

            if (isVisited.contains(cur.src) && isVisited.contains(cur.dest)) {
                continue;
            }

            if(!isVisited.contains(cur.src)){
                isVisited.add(cur.src);

                for(Bridge next : connection[cur.src]){
                    road.add(next);
                }
            }

            if(!isVisited.contains(cur.dest)){
                isVisited.add(cur.dest);

                for(Bridge next : connection[cur.dest]){
                    road.add(next);
                }
            }

            max = Math.min(max, cur.w);
        }

        if (!isVisited.contains(S) || !isVisited.contains(E)) {
            max = Integer.MAX_VALUE;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        max = Integer.MAX_VALUE;

        road = new PriorityQueue<>();
        isVisited = new HashSet<>();
        connection = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            connection[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            connection[h1].add(new Bridge(h1, h2, k));
            connection[h2].add(new Bridge(h2, h1, k));
        }

        for (Bridge cur : connection[S]) {
            road.add(cur);
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        Prims();
        System.out.println(max == Integer.MAX_VALUE ? 0 : max);
    }

    static class Bridge implements Comparable<Bridge> {
        int src, dest, w;

        public Bridge(int src, int dest, int w) {
            this.src = src;
            this.dest = dest;
            this.w = w;
        }

        @Override
        public int compareTo(Bridge o) {
            return o.w - this.w;
        }
    }
}