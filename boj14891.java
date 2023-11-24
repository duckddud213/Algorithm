import java.io.*;
import java.util.*;

public class boj14891 {
    static int K;
    static String gear[][];
    static int gearIndex[];
    static Turn doTurn[];
    static int isTurn[]; // -1: 반시계 회전 0: 정지 1: 시계 회전

    public static void spin() {
        int x, i, j, gi, gj;
        for (x = 0; x < K; x++) {
            isTurn[doTurn[x].wheelNum - 1] = doTurn[x].dir;

            for (i = doTurn[x].wheelNum - 1; i > 0; i--) {
                if (isTurn[i] == 0) { // 현재 위치 톱니가 회전하지 않는 상태인 경우
                    isTurn[i - 1] = 0;
                } else {
                    gi = moveIndex(gearIndex[i]);
                    gj = moveIndex(gearIndex[i - 1]);
                    if (i == 2) {
                        gi = moveIndex(gi + 4);
                        gj = moveIndex(gj - 4);
                    }
                    if (gear[i][gi].equals(gear[i - 1][gj])) { // 같은 극인 경우
                        isTurn[i - 1] = 0;
                    } else { // 다른 극인 경우
                        isTurn[i - 1] = isTurn[i] * (-1);
                    }
                }
            }

            for (i = doTurn[x].wheelNum - 1; i < 3; i++) {
                if (isTurn[i] == 0) { // 현재 위치 톱니가 회전하지 않는 상태인 경우
                    isTurn[i + 1] = 0;
                } else {
                    gi = moveIndex(gearIndex[i]);
                    gj = moveIndex(gearIndex[i + 1]);
                    if (i == 1) {
                        gi = moveIndex(gi - 4);
                        gj = moveIndex(gj + 4);
                    }
                    if (gear[i][gi].equals(gear[i + 1][gj])) { // 같은 극인 경우
                        isTurn[i + 1] = 0;
                    } else { // 다른 극인 경우
                        isTurn[i + 1] = isTurn[i] * (-1);
                    }
                }
            }

            for (i = 0; i < 4; i++) {
                gearIndex[i] = moveIndex(gearIndex[i] + (-1) * isTurn[i]);
            }
        }

        gear[0][0] = gear[0][moveIndex(gearIndex[0] - 2)];
        gear[1][0] = gear[1][moveIndex(gearIndex[1] - 6)];
        gear[2][0] = gear[2][moveIndex(gearIndex[2] - 2)];
        gear[3][0] = gear[3][moveIndex(gearIndex[3] - 6)];
    }

    public static int moveIndex(int index) {
        if (index < 0) {
            return 8 + index;
        } else if (index > 7) {
            return index % 8;
        }
        return index;
    }

    public static void pre() throws IOException {
        int i;
        gear = new String[4][8];
        gearIndex = new int[4];
        isTurn = new int[4];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (i = 0; i < 4; i++) {
            gear[i] = br.readLine().split("");
        }

        K = Integer.parseInt(br.readLine());
        doTurn = new Turn[K];
        gearIndex[0] = 2;
        gearIndex[1] = 6;
        gearIndex[2] = 2;
        gearIndex[3] = 6;

        for (i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            doTurn[i] = new Turn(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        spin();
        System.out.println(Integer.parseInt(gear[0][0]) + Integer.parseInt(gear[1][0]) * 2
                + Integer.parseInt(gear[2][0]) * 4 + Integer.parseInt(gear[3][0]) * 8);
    }

    static class Turn {
        int wheelNum, dir;

        public Turn() {
        }

        public Turn(int wheelNum, int dir) {
            this.wheelNum = wheelNum;
            this.dir = dir;
        }
    }
}