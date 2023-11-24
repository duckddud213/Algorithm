import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14503test {

    public static void main(String[] args) throws IOException {

        // d가 0:북쪽, 1: 동쪽, 2: 남쪽, 3:서쪽
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 방 크기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 로봇청소기의 좌표, 방향
        int r = Integer.parseInt(st.nextToken()); // x
        int c = Integer.parseInt(st.nextToken()); // y
        int d = Integer.parseInt(st.nextToken()); // 방향

        // 방 입력받기
        int[][] room = new int[n][m];
        boolean[][] isClean = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == 0) {
                    isClean[i][j] = false;
                } else {
                    isClean[i][j] = true; // 벽이거나, 청소되었거나
                }
            }
        }

        int clean = 0; // 청소하는 칸
        while (true) {
            // 현재 칸이 청소되지 않은 경우, 현재 칸 청소
            if (!isClean[r][c]) {
                isClean[r][c] = true;
                clean++;

                System.out.println("1현재 d,r,c : "+d+"," + r + "," + c);
            }

            int cnt = 0;
            for (int i = 0; i <= 3; i++) {
                if (r + dx[i] < n && c + dy[i] < m && r + dx[i] >= 0 && c + dy[i] >= 0) { // 인덱스 체크
                    if ((room[r + dx[i]][c + dy[i]] == 0 && isClean[r + dx[i]][c + dy[i]])
                            || room[r + dx[i]][c + dy[i]] == 1)
                        cnt++;
                }
            }
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            if (cnt == 4) {
                // 바라보는 방향을 유지한채로 한 칸 후진 할 수 있다면 한 칸 후진 후 1번
                // System.out.println("후진가능?: "+room[r-dx[d]][c-dy[d]]);
                if (room[r - dx[d]][c - dy[d]] == 0) {
                    r = r - dx[d];
                    c = c - dy[d];
                    System.out.println("2현재 d,r,c : "+d+"," + r + "," + c);
                    continue;
                } else {
                    System.out.println("3현재 d,r,c : "+d+"," + r + "," + c);
                    // 후진할 수 없다면 >>작동멈춤<<
                    break;
                }

            } else {
                // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
                // 반시계방향으로 90도 회전(dx, dy배열 -1)
                d--;
                if (d == -1)
                    d = 3;

                System.out.println("4현재 d,r,c : "+d+"," + r + "," + c);
                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지않은 빈칸이면 한칸 전진
                if (room[r + dx[d]][c + dy[d]] == 0 && !isClean[r + dx[d]][c + dy[d]]) {
                    r = r + dx[d];
                    c = c + dy[d];
                    System.out.println("5현재 d,r,c : "+d+"," + r + "," + c);
                }

            }

        }

        System.out.println(clean);

    }

}