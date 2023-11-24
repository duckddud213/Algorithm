import java.io.*;
import java.util.*;

public class boj2468 {
    static int N, maxHeight, maxLand, cnt;
    static int land[][];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void bfs() {
        int h, i, j, idx, qi, qj, qix, qjy;

        for (h = 1; h < maxHeight; h++) { // 높이를 1부터 최대 높이(maxHeight)까지 높이면서 bfs
            boolean isVisited[][] = new boolean[N][N]; // 방문한 지역인지 확인하는 boolean 배열
            Deque<dot> que = new ArrayDeque<>(); // 다음 방문할 지역을 저장하는 dot 타입 덱 que
            cnt = 0;// 섬의 수 count

            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    if (isVisited[i][j] || land[i][j] - h <= 0) { // 이미 방문했거나 물에 잠긴 지역인 경우
                        continue;
                    }

                    isVisited[i][j] = true; // 새로운 지역 발견시 ->bfs 탐색을 통해 isVisited 갱신
                    dot newDot = new dot();
                    newDot.x = i;
                    newDot.y = j;
                    que.add(newDot);

                    while (!que.isEmpty()) { // 더이상 이어진 땅이 없을 때까지 bfs 탐색
                        dot queDot = new dot();
                        queDot = que.poll();
                        qi = queDot.x;
                        qj = queDot.y;
                        for (idx = 0; idx < 4; idx++) {
                            qix = qi + dx[idx];
                            qjy = qj + dy[idx];
                            if (qix >= 0 && qix < N && qjy >= 0 && qjy < N && !isVisited[qix][qjy]
                                    && land[qix][qjy] - h > 0) {
                                dot inputDot = new dot();
                                inputDot.x = qix;
                                inputDot.y = qjy;
                                isVisited[qix][qjy] = true;
                                que.addLast(inputDot);
                            }
                        }
                    }
                    cnt++;
                }
            }

            if (cnt > maxLand) {
                maxLand = cnt;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, num;

        N = Integer.parseInt(br.readLine());

        land = new int[N][N];

        maxHeight = 0;
        for (i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (j = 0; j < N; j++) {
                num = Integer.parseInt(st.nextToken());
                if (num > maxHeight) { // 지형 중 가장 높이가 높은 곳을 maxHeight로 지정
                    maxHeight = num;
                }
                land[i][j] = num;
            }
        }
        maxLand = 1; // 물에 일정 높이로 잠겼을때 생길 수 있는 최대 섬의 수(아무 섬도 물에 잠기지 않을 경우 영역의 개수 = 1)
        bfs();
        System.out.println(maxLand);
    }

    static class dot {
        int x, y;
    }
}
