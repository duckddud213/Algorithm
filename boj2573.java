import java.io.*;
import java.util.*;

public class boj2573 {
    static int N, M, cntLand, cntYear;
    static int[][] iceberg;
    static int[][] closeWater;
    static boolean[][] isVisited;
    static Deque<dot> que;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void shaveIceberg() { // bfs Ž�� �� ���� ������ ������ŭ ������ ��� �Լ�(�� ó���� ȣ�� �� �� =>���̴� ���� 0)
        int i, j, index, i_dx, j_dy, cnt, si, sj;

        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                if (iceberg[i][j] != 0) {
                    cnt = 0;
                    for (index = 0; index < 4; index++) {
                        i_dx = i + dx[index];
                        j_dy = j + dy[index];
                        if (i_dx >= 0 && i_dx < N && j_dy >= 0 && j_dy < M && iceberg[i_dx][j_dy] == 0) {
                            cnt++;
                        }
                    }

                    closeWater[i][j] = cnt;

                    dot iceDot = new dot();
                    iceDot.x = i;
                    iceDot.y = j;

                    que.add(iceDot);
                }
            }
        }

        for (dot shave : que) { // closeWater�� ����� ������ ���� ������ ��Ƽ� ����
            si = shave.x;
            sj = shave.y;
            iceberg[si][sj] -= closeWater[si][sj];
            if (iceberg[si][sj] < 0) {
                iceberg[si][sj] = 0;
            }
        }

        que.clear(); // bfs���� que�� ����ϱ� ���� que�� ���
    }

    public static void bfs() {
        int i, j, index, qi, qj, qix, qjy;

        isVisited = new boolean[N][M];
        cntLand = 0;

        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                if (iceberg[i][j] != 0 && !isVisited[i][j]) { // ���� �߽߰� bfs Ž��
                    cntLand++;// ���� ����� ���� + 1
                    dot newLand = new dot();
                    newLand.x = i;
                    newLand.y = j;
                    isVisited[i][j] = true;

                    que.add(newLand);

                    while (!que.isEmpty()) {
                        dot queLand = que.poll();
                        qi = queLand.x;
                        qj = queLand.y;

                        for (index = 0; index < 4; index++) {
                            qix = qi + dx[index];
                            qjy = qj + dy[index];

                            if (qix >= 0 && qix < N && qjy >= 0 && qjy < M) {
                                if (!isVisited[qix][qjy] && iceberg[qix][qjy] != 0) { // �ε��� ���� ���̰�, �湮���� ���� �����϶�
                                    queLand = new dot();
                                    queLand.x = qix;
                                    queLand.y = qjy;
                                    que.add(queLand);
                                    isVisited[qix][qjy] = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (cntLand == 1) { // ���� ����� 1���� ���
            shaveIceberg();// ������ ����
            cntYear++;// ������ �� �� ���������� 1�⾿ ����
            bfs(); // ���� �������� �ٽ� bfs
        } else if (cntLand == 0) { // ������ ���� ���� ��� = 2�� �̻����� �������� ��
            cntYear = 0;
        }
    }

    public static void pre() throws IOException {
        int i, j;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cntYear = 0;

        iceberg = new int[N][M];
        closeWater = new int[N][M];
        que = new ArrayDeque<>();

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        bfs();
        System.out.println(cntYear);
    }

    static class dot {
        int x, y;
    }
}
