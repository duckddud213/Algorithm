import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14503test {

    public static void main(String[] args) throws IOException {

        // d�� 0:����, 1: ����, 2: ����, 3:����
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // �� ũ��
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // �κ�û�ұ��� ��ǥ, ����
        int r = Integer.parseInt(st.nextToken()); // x
        int c = Integer.parseInt(st.nextToken()); // y
        int d = Integer.parseInt(st.nextToken()); // ����

        // �� �Է¹ޱ�
        int[][] room = new int[n][m];
        boolean[][] isClean = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == 0) {
                    isClean[i][j] = false;
                } else {
                    isClean[i][j] = true; // ���̰ų�, û�ҵǾ��ų�
                }
            }
        }

        int clean = 0; // û���ϴ� ĭ
        while (true) {
            // ���� ĭ�� û�ҵ��� ���� ���, ���� ĭ û��
            if (!isClean[r][c]) {
                isClean[r][c] = true;
                clean++;

                System.out.println("1���� d,r,c : "+d+"," + r + "," + c);
            }

            int cnt = 0;
            for (int i = 0; i <= 3; i++) {
                if (r + dx[i] < n && c + dy[i] < m && r + dx[i] >= 0 && c + dy[i] >= 0) { // �ε��� üũ
                    if ((room[r + dx[i]][c + dy[i]] == 0 && isClean[r + dx[i]][c + dy[i]])
                            || room[r + dx[i]][c + dy[i]] == 1)
                        cnt++;
                }
            }
            // ���� ĭ�� �ֺ� 4ĭ �� û�ҵ��� ���� �� ĭ�� ���� ���,
            if (cnt == 4) {
                // �ٶ󺸴� ������ ������ä�� �� ĭ ���� �� �� �ִٸ� �� ĭ ���� �� 1��
                // System.out.println("��������?: "+room[r-dx[d]][c-dy[d]]);
                if (room[r - dx[d]][c - dy[d]] == 0) {
                    r = r - dx[d];
                    c = c - dy[d];
                    System.out.println("2���� d,r,c : "+d+"," + r + "," + c);
                    continue;
                } else {
                    System.out.println("3���� d,r,c : "+d+"," + r + "," + c);
                    // ������ �� ���ٸ� >>�۵�����<<
                    break;
                }

            } else {
                // ���� ĭ�� �ֺ� 4ĭ �� û�ҵ��� ���� �� ĭ�� �ִ� ���,
                // �ݽð�������� 90�� ȸ��(dx, dy�迭 -1)
                d--;
                if (d == -1)
                    d = 3;

                System.out.println("4���� d,r,c : "+d+"," + r + "," + c);
                // �ٶ󺸴� ������ �������� ���� ĭ�� û�ҵ������� ��ĭ�̸� ��ĭ ����
                if (room[r + dx[d]][c + dy[d]] == 0 && !isClean[r + dx[d]][c + dy[d]]) {
                    r = r + dx[d];
                    c = c + dy[d];
                    System.out.println("5���� d,r,c : "+d+"," + r + "," + c);
                }

            }

        }

        System.out.println(clean);

    }

}