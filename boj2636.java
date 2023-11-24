import java.io.*;
import java.util.*;

public class boj2636 {
    static int N, M, cntCheese, meltHour, beforeMeltAll;
    static int board[][];
    static boolean isVisited[][];
    static boolean isVisitedAir[][];
    static Deque<dot> cheese;
    static Deque<dot> air;
    static Deque<dot> meltingCheese;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void cheeseOutside() {
        // ���� �����ڸ��� ���� ġ� �����Ƿ� �����ڸ��� ���������� bfsŽ���Ͽ� ����� ������ ġ���� dot�� ������ ����
        int qi, qj, idx, qix, qjy;
        isVisitedAir = new boolean[N][M];

        dot inputDot = new dot(0, 0);
        isVisitedAir[0][0] = true;
        air.add(inputDot);

        while (!air.isEmpty()) {
            dot airDot = air.poll();
            qi = airDot.i;
            qj = airDot.j;

            for (idx = 0; idx < 4; idx++) {
                qix = qi + dx[idx];
                qjy = qj + dy[idx];

                if (valid(qix, qjy)) {
                    if (!isVisitedAir[qix][qjy] && board[qix][qjy] == 0) {// ���� �湮���� ���� ������ ���
                        isVisitedAir[qix][qjy] = true;
                        airDot = new dot(qix, qjy);
                        air.addLast(airDot);
                    }
                    if (board[qix][qjy] == 1) {
                        dot cheeseDot = new dot(qix, qjy);
                        meltingCheese.add(cheeseDot);
                    }
                }
            }
        }

        for (dot melt : meltingCheese) {
            qi = melt.i;
            qj = melt.j;
            board[qi][qj] = 0;
        }
        meltingCheese.clear();
    }

    public static void bfs() {
        int i, j, qi, qj, idx, qix, qjy;
        isVisited = new boolean[N][M];
        cntCheese = 0;

        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                if (board[i][j] == 0 || isVisited[i][j]) {
                    continue;
                }

                dot inputDot = new dot(i, j);
                isVisited[i][j] = true;
                cheese.addLast(inputDot);

                while (!cheese.isEmpty()) {
                    dot queDot = cheese.poll();
                    qi = queDot.i;
                    qj = queDot.j;
                    cntCheese++;

                    for (idx = 0; idx < 4; idx++) {
                        qix = qi + dx[idx];
                        qjy = qj + dy[idx];

                        if (valid(qix, qjy) && !isVisited[qix][qjy] && board[qix][qjy] == 1) {
                            isVisited[qix][qjy] = true;
                            queDot = new dot(qix, qjy);
                            cheese.addLast(queDot);
                        }
                    }
                }
            }
        }

        if (cntCheese > 0) {// ġ� �� �����̻� �ִ� ���
            cheeseOutside();
            meltHour++;
            beforeMeltAll = cntCheese;
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
        meltHour = 0;

        board = new int[N][M];
        cheese = new ArrayDeque<>();
        air = new ArrayDeque<>();
        meltingCheese = new ArrayDeque<>();

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        bfs();
        // bfs() �Լ��� ġ���� ���� ���� �� 1�̻��̸� cheeseOutside����
        // cheeseOutside() �Լ��� ���� ġ�� �ܺο��� bfsŽ�� ���� �� ��� ġ�� �ݿ� �� �ٽ� bfs() �Լ� ����
        System.out.println(meltHour);
        System.out.println(beforeMeltAll);
    }

    static class dot {
        int i, j;

        public dot() {
        }

        public dot(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}