import java.io.*;
import java.util.*;

public class boj1774 {
    static int N, M;
    static double ans;
    static int parent[];
    static Pos points[];
    static List<Edge> edgeList;

    public static void Kruskal() {
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double weight = distance(points[i], points[j]);

                edgeList.add(new Edge(points[i].num, points[j].num, weight));
            }
        }
        Collections.sort(edgeList);

        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            if (find(edge.start) != find(edge.end)) {
                ans += edge.weight;
                union(edge.start, edge.end);
            }
        }
    }

	public static double distance(Pos p1, Pos p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }
    
    public static void pre() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0.0;
		
		parent = new int[N + 1];
		points = new Pos[N + 1];
        edgeList = new ArrayList<>();
        
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			points[i] = new Pos(i, x, y);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());

			union(src, dest);
		}
    }

    public static void main(String[] args) throws IOException {
        pre();
        Kruskal();
        System.out.printf("%.2f", ans);
	}
    
    static class Pos {
        int num;
        double x;
        double y;
        
        public Pos() {
        }
    
        public Pos(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        double weight;
    
        Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    
        @Override
        public int compareTo(Edge o) {
            if (weight < o.weight) {
                return -1;
            }
            return 1;
        }
    }
}