import java.io.*;
import java.util.*;

public class boj1865 {
    static int x, TC, N, M, W, S, E, T;
    static boolean flag;
    static StringBuilder sb;
    static ArrayList<Node>[] edge;
    static int[] distance;
    static int INF = 2000000000;

    public static void bellmanFord(int src, int dist[]) {
        int i, j, k;
        boolean updated = false;
        dist[src] = 0;

        for (i = 0; i <= N; i++) {
            updated = false;
            for (j = 0; j <= N; j++) {
                if (dist[j] != INF) {
                    for (Node cur : edge[j]) {
                        if (dist[cur.dest] > cur.weight + dist[j]) {
                            dist[cur.dest] = cur.weight + dist[j];
                            updated = true;
                        }
                    }
                }
            }
            if(!updated){
                break;
            }
        }

        if (updated) {
            updated = false;
            for (j = 0; j <= N; j++) {
                if (dist[j] != INF) {
                    for (Node cur : edge[j]) {
                        if (dist[cur.dest] > cur.weight + dist[j]) {
                            dist[cur.dest] = cur.weight + dist[j];
                            updated = true;
                        }
                    }
                }
            }
        }

        sb.append(updated ? "YES" : "NO").append('\n');

    }

    public static void pre() throws IOException {
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());

        for (x = 1; x <= TC; x++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            flag = false;

            edge = new ArrayList[N + 1];
            distance = new int[N + 1];

            for (i = 0; i <= N; i++) {
                edge[i] = new ArrayList<>();
                distance[i] = INF;
            }

            // 양의 간선 입력
            for (i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                edge[S].add(new Node(E, T));
                edge[E].add(new Node(S,T));
            }

            // 음의 간선 입력
            for (i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                edge[S].add(new Node(E, T * (-1)));
            }

            for (i = 1; i <= N; i++) {
                edge[0].add(new Node(i, 0));
            }

            bellmanFord(0, distance);
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }

    static class Node {
        int dest, weight;

        public Node() {
        }

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}