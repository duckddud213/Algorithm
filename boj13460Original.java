import java.io.*;
import java.util.*;

public class boj13460Original {
    static int N, M, cnt;
    static char board[][];
    static boolean isVisited[][];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static dot red, blue, Hole;
    static Deque<dot> redQue;
    static Deque<dot> blueQue;

    public static void moveMarble() {

    }

    public static void bfs() {
        int qi, qj, idx, qix, qjy, cntRed, cntBlue, blueI, blueJ;
        dot queDot, blueDot, inputDot; // queDot ���� ���� ��ǥ blueDot �Ķ� ���� ��ǥ inputDot ť�� �ִ� ��ǥ

        redQue.add(red); // ���� ���� dot �����ϴ� redQue�� �ʱⰪ ����
        blueQue.add(blue); // �Ķ� ���� dot �����ϴ� blueQue�� �ʱⰪ ����

        while (!redQue.isEmpty()) {
            queDot = redQue.poll();
            blueDot = blueQue.poll();

            if (queDot.depth > 10) {
                System.out.println("-1");
                return;
            }

            qi = queDot.i;
            qj = queDot.j;

            for (idx = 0; idx < 4; idx++) {

                qix = qi + dx[idx];
                qjy = qj + dy[idx];
                blueI = blueDot.i + dx[idx];
                blueJ = blueDot.j + dy[idx];

                cntRed = 0;
                cntBlue = 0;

                while (isNotWallOrHole(qix, qjy)) {
                    cntRed++;
                    qix += dx[idx];
                    qjy += dy[idx];
                }

                while (isNotWallOrHole(blueI, blueJ)) {
                    cntBlue++;
                    blueI += dx[idx];
                    blueJ += dy[idx];
                }

                if (blueI == Hole.i && blueJ == Hole.j) { // �Ķ����� ���ۿ� ������ ��� : ����
                    continue;
                }

                else if (qix == Hole.i && qjy == Hole.j) { // �������� ���ۿ� ������ ��� : ����
                    System.out.println(queDot.depth + 1);
                    return;
                }

                if (qix == blueI && qjy == blueJ) { // �� ��ġ�� ��ģ ���
                    if (cntRed > cntBlue) { // ���� ������ ������ Ƚ���� �Ķ� ������ ������ Ƚ������ ���� ���
                        qix -= dx[idx];
                        qjy -= dy[idx];
                    } else {
                        blueI -= dx[idx];
                        blueJ -= dy[idx];
                    }
                }
                inputDot = new dot(qix, qjy);
                inputDot.depth = queDot.depth + 1;

            }
        }

    }

    public static boolean isNotWallOrHole(int i, int j) {
        if (board[i][j] != '#' && (i != Hole.i || j != Hole.j)) {
            return true;
        }
        return false;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;

        board = new char[N][M];
        redQue = new ArrayDeque<>();
        blueQue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String inp[] = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = inp[j].charAt(j);
                if (board[i][j] == 'R') {
                    red = new dot(i, j);
                    red.depth = 0;
                }
                if (board[i][j] == 'B') {
                    blue = new dot(i, j);
                    blue.depth = 0;
                }
                if (board[i][j] == 'O') {
                    Hole = new dot(i, j);
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        bfs();
    }

    static class dot {
        int i, j, depth;

        public dot() {
        }

        public dot(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}