import java.io.*;
import java.util.*;

public class boj2636Original {
    static int N, M, meltHour, beforeMeltAll, cntCheese;
    static int cheese[][];
    static Deque<dot> que;
    static Deque<dot> outline;
    static boolean checkedOut[][];
    static boolean isVisited[][];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    // meltHout : 치즈가 다 녹는데 걸리는 시간
    // beforeMeltAll : 치즈가 다 녹기 한 시간 전 남아있던 치즈 양
    // cntCheese : bfs 탐색 후 확인한 현재 남은 치즈의 양

    public static void meltCheese() {
        int i, j, idx, qi, qj, qix, qjy;
        isVisited = new boolean[N][M];
        checkedOut = new boolean[N][M];

        // 가장자리는 무조건 공기가 있는 빈칸
        // 치즈 외부에서 bfs해서 치즈 겉면 위치값 저장 후 0으로 저장
        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {

                if (i != 0 && i != N - 1 && j != 0 && j != M - 1) { // 판의 가장자리가 아닌 경우
                    continue;
                }
                if (isVisited[i][j] || cheese[i][j] == 1) {
                    continue;
                }

                dot outDot = new dot();
                outDot.x = i;
                outDot.y = j;
                isVisited[i][j] = true;
                que.add(outDot);

                while (!que.isEmpty()) {
                    dot queDot = que.poll();
                    qi = queDot.x;
                    qj = queDot.y;

                    for (idx = 0; idx < 4; idx++) {
                        qix = qi + dx[idx];
                        qjy = qj + dy[idx];

                        if (valid(qix, qjy)) {
                            if (cheese[qix][qjy] == 1 && !checkedOut[qix][qjy]) { // 치즈 겉면이고, 아직 확인 안 된 경우 :outline que에
                                                                                  // 좌표 입력
                                checkedOut[qix][qjy] = true;
                                dot cheeseOut = new dot();
                                cheeseOut.x = qix;
                                cheeseOut.y = qjy;
                                outline.addLast(cheeseOut);
                            }
                            if (cheese[qix][qjy] == 0 && isVisited[qix][qjy]) { // 외부 공기이고, 아직 방문 안 한 경우 : que에 좌표 입력
                                isVisited[qix][qjy] = true;
                                dot air = new dot();
                                air.x = qix;
                                air.y = qjy;
                                outline.addLast(air);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void bfs() {
        int i, j, idx, qi, qj, qix, qjy;
        cntCheese = 0;
        isVisited = new boolean[N][M];

        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                if (cheese[i][j] == 0 || isVisited[i][j]) {
                    continue;
                }

                dot newDot = new dot();
                newDot.x = i;
                newDot.y = j;
                isVisited[i][j] = true;
                que.addLast(newDot);

                while (!que.isEmpty()) {
                    dot queDot = que.poll();
                    qi = queDot.x;
                    qj = queDot.y;

                    cntCheese++;

                    for (idx = 0; idx < 4; idx++) {
                        qix = qi + dx[idx];
                        qjy = qj + dy[idx];

                        if (valid(qix, qjy) && !isVisited[qix][qjy] && cheese[qix][qjy] == 1) {
                            queDot = new dot();
                            queDot.x = qix;
                            queDot.y = qjy;
                            que.addLast(queDot);
                            isVisited[qix][qjy] = true;
                        }
                    }
                }
            }
        }

        if (cntCheese > 0) {
            beforeMeltAll = cntCheese;
            meltHour++;
            meltCheese();
            bfs();
        }
    }

    public static boolean valid(int a, int b) {
        if (a >= 0 && a < N && b >= 0 && b < M) {
            return true;
        }

        return false;
    }

    public static void pre() throws IOException {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheese = new int[N][M];
        isVisited = new boolean[N][M];
        que = new ArrayDeque<>();
        outline = new ArrayDeque<>();

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        meltHour = 0;
    }

    public static void main(String args[]) throws IOException {
        pre();
        bfs();
        System.out.println(meltHour);
        System.out.println(beforeMeltAll);
    }

    static class dot {
        int x, y;
    }
}