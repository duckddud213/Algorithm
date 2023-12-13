import java.io.*;
import java.util.*;

public class boj11657 {
    static int N, M;
    static long INF;
    static List<Route> edge;
    static long[] shortest;

    public static boolean bellmanFord() {
        shortest[1] = 0;

        for (int i = 1; i <= N; i++) {
            for (Route r : edge) {
                int src = r.src;
                int dest = r.dest;
                int time = r.time;

                if (shortest[src] != INF && shortest[dest] > shortest[src] + time) {
                    shortest[dest] = shortest[src] + time;
                    if (i == N) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        INF = Long.MAX_VALUE;

        edge = new ArrayList<>();
        shortest = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            shortest[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edge.add(new Route(A,B,C));
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        if (bellmanFord()) {
            System.out.println(-1);
        }
        else {
            for (int i = 2; i <= N; i++) {
                System.out.println(shortest[i]==Long.MAX_VALUE?-1:shortest[i]);
            }
        }
    }

    static class Route {
        int src,dest, time;

        public Route() {
        }

        public Route(int src, int dest, int time) {
            this.src = src;
            this.dest = dest;
            this.time = time;
        }
    }
}
