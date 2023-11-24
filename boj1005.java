import java.io.*;
import java.util.*;

public class boj1005 {
    static int x, T, N, K,W;
    static int buildtime[], enterLine[];
    static boolean direction[][];
    static StringBuilder sb;

    public static void TopologicalSort() {
        Deque<Integer> que = new ArrayDeque<>();
        int result[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (enterLine[i] == 0) {
                result[i] = buildtime[i];
                que.add(i);
            }
        }

        while (!que.isEmpty())
		{
			int prev = que.poll();
			
			for (int i = 1; i <=N; i++)
			{
				if (direction[prev][i])
				{
					result[i] = Math.max(result[i], result[prev] + buildtime[i]);
                    enterLine[i]--;
                    
					if (enterLine[i] == 0)
					{
						que.add(i);
					}
				}
			}
		}

        sb.append(result[W]).append('\n');
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
                                        
        T = Integer.parseInt(br.readLine());

        for (x = 1; x <= T; x++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            buildtime = new int[N + 1];
            enterLine = new int[N + 1];
            direction = new boolean[N + 1][N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildtime[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());

                enterLine[V]++;
                direction[U][V] = true;
            }
            W = Integer.parseInt(br.readLine());

            TopologicalSort();
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}