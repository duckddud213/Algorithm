import java.io.*;
import java.util.*;

public class boj13460 {
    static int N, M, cnt;
    static int ri, rj, bi, bj, idx, rix, rjy, bix, bjy, cntRedMove, cntBlueMove;
    static char board[][];
    static int depth[][];
    static boolean isVisitedRed[][];
    static boolean isVisitedBlue[][];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static dot red, blue, Hole, input;
    static Deque<dot> redQue;
    static Deque<dot> blueQue;

    public static void countMarbleMove() {
        while (isNotWallOrHole(rix, rjy)) {
            rix += dx[idx];
            rjy += dy[idx];
            cntRedMove++;
        }

        while (isNotWallOrHole(bix, bjy)) {
            bix += dx[idx];
            bjy += dy[idx];
            cntBlueMove++;
        }

        rix -= dx[idx];
        rjy -= dy[idx];
        bix -= dx[idx];
        bjy -= dy[idx];
    }

    public static void bfs() {

        redQue.add(red);
        blueQue.add(blue);

        while (!redQue.isEmpty()) {
            red = redQue.poll();
            blue = blueQue.poll();

            ri = red.i;
            rj = red.j;
            bi = blue.i;
            bj = blue.j;

            if (depth[ri][rj] > 10) {
                System.out.println("-1");
                return;
            }

            for (idx = 0; idx < 4; idx++) {
                rix = ri + dx[idx];
                rjy = rj + dy[idx];
                bix = bi + dx[idx];
                bjy = bj + dy[idx];
                cntRedMove = 0;
                cntBlueMove = 0;

                countMarbleMove();
                System.out.println(rix + " " + rjy + " " + bix + " " + bjy);

                if (bix + dx[idx] == Hole.i && bjy + dy[idx] == Hole.j) { // �Ķ� ������ ���ۿ� ������ ���
                    continue;
                }
                if (rix + dx[idx] == Hole.i && rjy + dy[idx] == Hole.j) { // ���� ������ ���ۿ� ������ ���
                    System.out.println(depth[ri][rj] + 1);
                    return;
                }

                if (rix == bix && rjy == bjy) { // ���� ������ �Ķ� ������ ���� ��ġ�� ���
                    if (cntRedMove > cntBlueMove) {
                        rix -= dx[idx];
                        rjy -= dy[idx];
                    } else {
                        bix -= dx[idx];
                        bjy -= dy[idx];
                    }
                    System.out.println(rix + " " + rjy + " " + bix + " " + bjy);
                }

                if (isVisitedRed[rix][rjy] && isVisitedBlue[bix][bjy]) {
                    continue;
                }

                input = new dot(rix, rjy);
                if (depth[rix][rjy] != 0) {
                    depth[rix][rjy] = Math.min(depth[rix][rjy], depth[ri][rj] + 1);
                } else {

                    depth[rix][rjy] = depth[ri][rj] + 1;
                }
                // input.depth = red.depth + 1;
                isVisitedRed[rix][rjy] = true;
                redQue.add(input);

                input = new dot(bix, bjy);
                isVisitedBlue[bix][bjy] = true;
                blueQue.add(input);
            }

        }
        System.out.println("-1"); // ť�� �� Ž���ص� ����� �� ���� ��� = �Ұ����� ���
    }

    public static boolean isNotWallOrHole(int i, int j) {
        if (board[i][j] == '#') {
            return false;
        }
        if (i == Hole.i && j == Hole.j) {
            return false;
        }
        return true;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;

        board = new char[N][M];
        depth = new int[N][M];
        isVisitedRed = new boolean[N][M];
        isVisitedBlue = new boolean[N][M];
        redQue = new ArrayDeque<>();
        blueQue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String inp[] = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = inp[j].charAt(0);
                if (board[i][j] == 'R') {
                    red = new dot(i, j);
                    depth[i][j] = 0;
                    isVisitedRed[i][j] = true;
                }
                if (board[i][j] == 'B') {
                    blue = new dot(i, j);
                    isVisitedBlue[i][j] = true;
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
        int i, j;

        public dot() {
        }

        public dot(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}