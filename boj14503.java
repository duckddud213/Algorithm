import java.io.*;

public class boj14503 {
    static int N, M, r, c, d, cnt;
    static int isCleaned[][]; // 청소 상태(청소 전 or 후 && 벽) 표현 배열

    public static int lookAround() { // 현재 위치 기준 주변 4칸 탐색
        if (r - 1 >= 0 && isCleaned[r - 1][c] == 0) {
            return 1;
        }
        if (c - 1 >= 0 && isCleaned[r][c - 1] == 0) {
            return 1;
        }
        if (r + 1 < N && isCleaned[r + 1][c] == 0) {
            return 1;
        }
        if (c + 1 < M && isCleaned[r][c + 1] == 0) {
            return 1;
        }
        return 0; // 주변 4칸에 청소할 곳이 없는 경우
    }

    public static boolean goBackward() {
        if (d == 0 && r + 1 < N && isCleaned[r + 1][c] != 2) { // 북쪽 바라보고 후진 가능한 경우 1칸 후진
            r++;
            return true;
        }
        if (d == 1 && c - 1 >= 0 && isCleaned[r][c - 1] != 2) { // 동쪽 바라보고 후진 가능한 경우 1칸 후진
            c--;
            return true;
        }
        if (d == 2 && r - 1 >= 0 && isCleaned[r - 1][c] != 2) { // 남쪽 바라보고 후진 가능한 경우 1칸 후진
            r--;
            return true;
        }
        if (d == 3 && c + 1 < M && isCleaned[r][c + 1] != 2) { // 서쪽 바라보고 후진 가능한 경우 1칸 후진
            c++;
            return true;
        }
        return false;// 후진 불가능한 경우
    }

    public static void goForward() {// 바라보는 방향 기준 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
        if (d == 0 && r - 1 >= 0 && isCleaned[r - 1][c] == 0) { // 북쪽 바라보고 앞쪽 칸이 청소되지 않은 빈 칸인 경우
            r--;
            return;
        }
        if (d == 1 && c + 1 < M && isCleaned[r][c + 1] == 0) { // 동쪽 바라보고 앞쪽 칸이 청소되지 않은 빈 칸인 경우
            c++;
            return;
        }
        if (d == 2 && r + 1 < N && isCleaned[r + 1][c] == 0) { // 남쪽 바라보고 앞쪽 칸이 청소되지 않은 빈 칸인 경우
            r++;
            return;
        }
        if (d == 3 && c - 1 >= 0 && isCleaned[r][c - 1] == 0) { // 서쪽 바라보고 앞쪽 칸이 청소되지 않은 빈 칸인 경우
            c--;
            return;
        }
    }

    public static void clean() {
        if (isCleaned[r][c] == 0) { // 현재 칸이 아직 청소되지 않은 경우
            cnt++;
            isCleaned[r][c] = 1;
        }

        if (lookAround() == 0) { // 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
            if (goBackward()) { // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있는 경우
                clean();// 다시 1번 시작
            } else { // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없는 경우 -> 작동 중지
                return;
            }
        } else {// 현재 4칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            d = (d + 3) % 4; // 반시계 방향 90도 회전 갱신
            goForward();
            clean();// 다시 1번으로
        }
    }

    public static void main(String args[]) throws IOException {
        int i, j;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String NM[] = br.readLine().split(" "); // 이 부분 확인 해봤는데 아예 공백으로 두면
        String inp[] = br.readLine().split(" "); // The method split(String) in the type String is not applicable for
                                                 // the arguments () 라고 뜨네요

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        r = Integer.parseInt(inp[0]);
        c = Integer.parseInt(inp[1]);
        d = Integer.parseInt(inp[2]);

        isCleaned = new int[N][M]; // 0 : 청소 X | 1 : 청소 O | 2 : 벽

        for (i = 0; i < N; i++) {
            String dirt[] = br.readLine().split(" "); // ()를 아예 안 쓰는것도 불가능
            for (j = 0; j < M; j++) {
                if (Integer.parseInt(dirt[j]) == 0) {
                    isCleaned[i][j] = 0;
                } else {
                    isCleaned[i][j] = 2;
                }
            }
        }

        cnt = 0;
        clean();

        System.out.println(cnt);
    }
}
