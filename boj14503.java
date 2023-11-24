import java.io.*;

public class boj14503 {
    static int N, M, r, c, d, cnt;
    static int isCleaned[][]; // û�� ����(û�� �� or �� && ��) ǥ�� �迭

    public static int lookAround() { // ���� ��ġ ���� �ֺ� 4ĭ Ž��
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
        return 0; // �ֺ� 4ĭ�� û���� ���� ���� ���
    }

    public static boolean goBackward() {
        if (d == 0 && r + 1 < N && isCleaned[r + 1][c] != 2) { // ���� �ٶ󺸰� ���� ������ ��� 1ĭ ����
            r++;
            return true;
        }
        if (d == 1 && c - 1 >= 0 && isCleaned[r][c - 1] != 2) { // ���� �ٶ󺸰� ���� ������ ��� 1ĭ ����
            c--;
            return true;
        }
        if (d == 2 && r - 1 >= 0 && isCleaned[r - 1][c] != 2) { // ���� �ٶ󺸰� ���� ������ ��� 1ĭ ����
            r--;
            return true;
        }
        if (d == 3 && c + 1 < M && isCleaned[r][c + 1] != 2) { // ���� �ٶ󺸰� ���� ������ ��� 1ĭ ����
            c++;
            return true;
        }
        return false;// ���� �Ұ����� ���
    }

    public static void goForward() {// �ٶ󺸴� ���� ���� ���� ĭ�� û�ҵ��� ���� �� ĭ�� ��� �� ĭ ����
        if (d == 0 && r - 1 >= 0 && isCleaned[r - 1][c] == 0) { // ���� �ٶ󺸰� ���� ĭ�� û�ҵ��� ���� �� ĭ�� ���
            r--;
            return;
        }
        if (d == 1 && c + 1 < M && isCleaned[r][c + 1] == 0) { // ���� �ٶ󺸰� ���� ĭ�� û�ҵ��� ���� �� ĭ�� ���
            c++;
            return;
        }
        if (d == 2 && r + 1 < N && isCleaned[r + 1][c] == 0) { // ���� �ٶ󺸰� ���� ĭ�� û�ҵ��� ���� �� ĭ�� ���
            r++;
            return;
        }
        if (d == 3 && c - 1 >= 0 && isCleaned[r][c - 1] == 0) { // ���� �ٶ󺸰� ���� ĭ�� û�ҵ��� ���� �� ĭ�� ���
            c--;
            return;
        }
    }

    public static void clean() {
        if (isCleaned[r][c] == 0) { // ���� ĭ�� ���� û�ҵ��� ���� ���
            cnt++;
            isCleaned[r][c] = 1;
        }

        if (lookAround() == 0) { // �ֺ� 4ĭ �� û�ҵ��� ���� ��ĭ�� ���� ���
            if (goBackward()) { // �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �� �ִ� ���
                clean();// �ٽ� 1�� ����
            } else { // �ٶ󺸴� ������ ���� ĭ�� ���̶� ������ �� ���� ��� -> �۵� ����
                return;
            }
        } else {// ���� 4ĭ�� �ֺ� 4ĭ �� û�ҵ��� ���� �� ĭ�� �ִ� ���
            d = (d + 3) % 4; // �ݽð� ���� 90�� ȸ�� ����
            goForward();
            clean();// �ٽ� 1������
        }
    }

    public static void main(String args[]) throws IOException {
        int i, j;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String NM[] = br.readLine().split(" "); // �� �κ� Ȯ�� �غôµ� �ƿ� �������� �θ�
        String inp[] = br.readLine().split(" "); // The method split(String) in the type String is not applicable for
                                                 // the arguments () ��� �߳׿�

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        r = Integer.parseInt(inp[0]);
        c = Integer.parseInt(inp[1]);
        d = Integer.parseInt(inp[2]);

        isCleaned = new int[N][M]; // 0 : û�� X | 1 : û�� O | 2 : ��

        for (i = 0; i < N; i++) {
            String dirt[] = br.readLine().split(" "); // ()�� �ƿ� �� ���°͵� �Ұ���
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
