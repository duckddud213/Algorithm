import java.io.*;
import java.util.*;

public class boj2667 {
    static List<Integer> town;
    static int N, townCnt, townSize; // townCnt : 총 단지수 || townSize : 단지 별 가구수
    static int map[][];
    static boolean isVisited[][];
    static Deque<dot> que;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void bfs() {
        int i, j, idx, qi, qj, qix, qjy;
        isVisited = new boolean[N][N];
        que = new ArrayDeque<>();
        town = new ArrayList<>();

        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (isVisited[i][j] || map[i][j] == 0) { // 방문한 집이거나 집이 없는 장소인 경우 다음 지역 탐색
                    continue;
                }

                townCnt++;
                townSize = 0;

                dot newDot = new dot(); // bfs 탐색 시작할 좌표를 que에 넣기 위해 저장
                newDot.x = i;
                newDot.y = j;
                isVisited[i][j] = true;

                que.add(newDot);

                while (!que.isEmpty()) {
                    townSize++;
                    dot queDot = que.poll();
                    qi = queDot.x;
                    qj = queDot.y;

                    for (idx = 0; idx < 4; idx++) {
                        qix = qi + dx[idx];
                        qjy = qj + dy[idx];

                        // 범위 안에 포함되고, 방문하지 않은 인접한 집이 있는 경우 que에 저장
                        if (qix >= 0 && qix < N && qjy >= 0 && qjy < N && map[qix][qjy] == 1 && !isVisited[qix][qjy]) {
                            dot inputDot = new dot();
                            inputDot.x = qix;
                            inputDot.y = qjy;
                            isVisited[qix][qjy] = true;
                            que.addLast(inputDot);
                        }
                    }
                }

                town.add(townSize); // town 리스트에 단지 크기 저장
            }
        }

        Collections.sort(town); // town 리스트에 저장된 단지 크기 정렬
    }

    public static void main(String args[]) throws IOException {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (i = 0; i < N; i++) {
            String inp[] = br.readLine().split("");
            for (j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inp[j]);
            }
        }
        townCnt = 0;
        bfs();

        System.out.println(townCnt); // 총 단지수 출력
        for (int a : town) {
            System.out.println(a); // 오름차순 정렬된 단지 내 집의 수를 출력
        }
    }

    static class dot {
        int x, y;
    }
}
