import java.io.*;
import java.util.*;

public class Main {
	static int N, M, V;
	static int map[][];
	static HashSet<Integer> hset;
	static StringBuilder sb;

	public static void bfs() {
		sb.append('\n');
		hset.clear();

		Deque<Integer> que = new ArrayDeque<>();

		que.add(V);

		while (!que.isEmpty()) {
			int num = que.poll();
			if (hset.contains(num)) {
				continue;
			}

			hset.add(num);
			sb.append(num).append(" ");

			for (int i = 1; i <= N; i++) {
				if (map[num][i] == 1 && !hset.contains(i)) {
					que.add(i);
				}
			}
		}
	}

	public static void dfs(int num) {
		sb.append(num).append(" ");
		for (int i = 1; i <= N; i++) {
			if (map[num][i] == 1 && !hset.contains(i)) {
				hset.add(i);
				dfs(i);
			}
		}
	}

	public static void pre() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		hset = new HashSet<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			map[A][B] = 1;
			map[B][A] = 1;
		}
		hset.add(V);
	}

	public static void main(String args[]) throws IOException {
		pre();
		dfs(V);
		bfs();
		System.out.println(sb);
	}
}