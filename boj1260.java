import java.util.Scanner;

public class boj1260 {
	public static void rDFS(int graph[][], int isVisited[], int N, int s) {

	}

	public static void DFS(int graph[][], int N, int V) {
		int isVisited[] = new int[N + 1];
		int i;

		for (i = 1; i <= N; i++) {
			isVisited[i] = 0;
		}
		
		for(i=1;i<=N;i++) {
			if((graph[V][i]==1)&&(isVisited[i]==0)) {
				rDFS(graph,isVisited,N,i);	
			}
		}
	}

	public static void BFS(int graph[][], int N, int V) {
		int isVisited[][] = new int[N + 1][N + 1];
		int que[] = new int[N + 1];
		int idx, newIn, i, j;

		idx = 0;
		que[idx] = V;
		newIn = 1;

		for (i = 0; i <= N; i++) {
			for (j = 0; j <= N; j++) {
				isVisited[i][j] = 0;
			}
		}

		while (que[idx] != 0) {
			for (j = 1; j <= N; j++) {
				if ((graph[que[idx]][j] == 1) && (isVisited[que[idx]][j] == 0)) {
					que[newIn] = j;
					newIn++;
					for (i = 1; i <= N; i++) {
						isVisited[i][j] = 1;
						isVisited[j][i] = 1;
					}
				}
			}
			System.out.print(que[idx] + " ");
			idx++;
		}
	}

	public static void main(String[] args) {
		int N, M, V, i, j, start, dest;

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		int graph[][] = new int[N + 1][N + 1];

		for (i = 0; i <= N; i++) {
			for (j = 0; j <= N; j++) {
				graph[i][j] = 0;
			}
		}

		for (i = 0; i < M; i++) {
			start = sc.nextInt();
			dest = sc.nextInt();
			graph[start][dest] = 1;
			graph[dest][start] = 1;
		}

		// dfs
		DFS(graph, N, V);
		// bfs
		BFS(graph, N, V);

	}
}
