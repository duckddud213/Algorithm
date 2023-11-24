import java.io.*;
import java.util.*;

public class boj17144 {
    static int R, C, T, sum, cntDir, spread;
    static int room[][];
    static int affect[][];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static boolean isChecked;
    static Loc Top, Bottom;
    static Deque<Loc> nearDust;

    public static void diffusion() { // �̼����� Ȯ�� �Լ�
        int i, j, idx;

        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                cntDir = 0;
                nearDust.clear();
                for (idx = 0; idx < 4; idx++) {
                    if (room[i][j] >= 0 && isValid(i + dx[idx], j + dy[idx])) {
                        cntDir++;
                        nearDust.add(new Loc(i + dx[idx], j + dy[idx]));
                    }
                }

                if (cntDir != 0) {
                    spread = Math.floorDiv(room[i][j], 5);
                    room[i][j] -= (spread * cntDir);
                    for (int k = 0; k < cntDir; k++) {
                        affect[nearDust.peekFirst().Row][nearDust.peekFirst().Col] += spread;
                        nearDust.pollFirst();
                    }
                }
            }
        }
    }

    public static void afterDiffusion() { // Ȯ�� �� �̼����� ��Ȳ �ݿ� �Լ�
        int i, j;

        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (room[i][j] != -1) {
                    room[i][j] += affect[i][j];
                }
            }
        }
        affect = new int[R][C];
    }

    public static void work() { // ����û���� �۵� �Լ�
        int tmp_i, tmp_j, dir;

        dir = 2; // dir 2 : ���� �̵� 1 : ������ �̵� 0 : �Ʒ� �̵� 3 : ���� �̵�
        // ���� ���� ��ȯ
        tmp_i = Top.Row - 1;
        tmp_j = 0;

        while (tmp_i != Top.Row || tmp_j != Top.Col) {
            // System.out.println("Current loc1 : " + tmp_i + " " + tmp_j);
            if (isCorner(0, tmp_i, tmp_j)) {
                dir--;
                if (dir == -1) {
                    dir = 3;
                }
            }
            room[tmp_i][tmp_j] = room[tmp_i + dx[dir]][tmp_j + dy[dir]];
            tmp_i += dx[dir];
            tmp_j += dy[dir];
        }
        room[tmp_i-dx[dir]][tmp_j-dy[dir]] = 0;

        dir = 0;
        // �Ʒ��� ���� ��ȯ
        tmp_i = Bottom.Row + 1;
        tmp_j = 0;

        while (tmp_i != Bottom.Row || tmp_j != Bottom.Col) {
            // System.out.println("Current loc2 : " + tmp_i + " " + tmp_j);
            if (isCorner(1, tmp_i, tmp_j)) {
                dir++;
            }
            room[tmp_i][tmp_j] = room[tmp_i + dx[dir]][tmp_j + dy[dir]];
            tmp_i += dx[dir];
            tmp_j += dy[dir];
        }
        room[tmp_i-dx[dir]][tmp_j-dy[dir]] = 0;

    }

    public static void procedure() {
        int i, j;
        for (i = 0; i < T; i++) {
            diffusion();
            afterDiffusion();
            work();
        }
        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (room[i][j] != -1) {
                    sum += room[i][j];
                }
            }
        }
    }

    public static void pre() throws IOException {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        nearDust = new ArrayDeque<>();
        isChecked = false;

        room = new int[R][C];
        affect = new int[R][C];
        sum = 0;

        for (i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1 && !isChecked) {
                    isChecked = true;
                    Top = new Loc(i, j);
                    Bottom = new Loc(i + 1, j);
                }
            }
        }

    }

    public static boolean isValid(int i, int j) {
        if (i < 0) {
            return false;
        }
        if (i >= R) {
            return false;
        }
        if (j < 0) {
            return false;
        }
        if (j >= C) {
            return false;
        }
        if (room[i][j] == -1) {// �κ� û�ұⰡ �ִ� ���� ��� Ȯ�� X
            return false;
        }
        return true;
    }

    public static boolean isCorner(int dir, int i, int j) { // �𼭸����� Ȯ���ϴ� �Լ� =>���� ��ȯ ����
        if (dir == 0) { // ����� ���
            if (i == 0 && j == 0) {
                return true;
            }
            if (i == 0 && j == C - 1) {
                return true;
            }
            if (i == Top.Row && j == 0) {
                return true;
            }
            if (i == Top.Row && j == C - 1) {
                return true;
            }
            return false;
        } else { // �ϴ��� ���
            if (i == Bottom.Row && j == 0) {
                return true;
            }
            if (i == R - 1 && j == 0) {
                return true;
            }
            if (i == R - 1 && j == C - 1) {
                return true;
            }
            if (i == Bottom.Row && j == C - 1) {
                return true;
            }

            return false;
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        procedure();
        System.out.println(sum);
    }

    static class Loc {
        int Row, Col;

        public Loc() {
        }

        public Loc(int Row, int Col) {
            this.Row = Row;
            this.Col = Col;
        }
    }
}