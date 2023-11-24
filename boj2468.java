import java.io.*;
import java.util.*;

public class boj2468 {
    static int N, maxHeight, maxLand, cnt;
    static int land[][];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void bfs() {
        int h, i, j, idx, qi, qj, qix, qjy;

        for (h = 1; h < maxHeight; h++) { // ���̸� 1���� �ִ� ����(maxHeight)���� ���̸鼭 bfs
            boolean isVisited[][] = new boolean[N][N]; // �湮�� �������� Ȯ���ϴ� boolean �迭
            Deque<dot> que = new ArrayDeque<>(); // ���� �湮�� ������ �����ϴ� dot Ÿ�� �� que
            cnt = 0;// ���� �� count

            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    if (isVisited[i][j] || land[i][j] - h <= 0) { // �̹� �湮�߰ų� ���� ��� ������ ���
                        continue;
                    }

                    isVisited[i][j] = true; // ���ο� ���� �߽߰� ->bfs Ž���� ���� isVisited ����
                    dot newDot = new dot();
                    newDot.x = i;
                    newDot.y = j;
                    que.add(newDot);

                    while (!que.isEmpty()) { // ���̻� �̾��� ���� ���� ������ bfs Ž��
                        dot queDot = new dot();
                        queDot = que.poll();
                        qi = queDot.x;
                        qj = queDot.y;
                        for (idx = 0; idx < 4; idx++) {
                            qix = qi + dx[idx];
                            qjy = qj + dy[idx];
                            if (qix >= 0 && qix < N && qjy >= 0 && qjy < N && !isVisited[qix][qjy]
                                    && land[qix][qjy] - h > 0) {
                                dot inputDot = new dot();
                                inputDot.x = qix;
                                inputDot.y = qjy;
                                isVisited[qix][qjy] = true;
                                que.addLast(inputDot);
                            }
                        }
                    }
                    cnt++;
                }
            }

            if (cnt > maxLand) {
                maxLand = cnt;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, num;

        N = Integer.parseInt(br.readLine());

        land = new int[N][N];

        maxHeight = 0;
        for (i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (j = 0; j < N; j++) {
                num = Integer.parseInt(st.nextToken());
                if (num > maxHeight) { // ���� �� ���� ���̰� ���� ���� maxHeight�� ����
                    maxHeight = num;
                }
                land[i][j] = num;
            }
        }
        maxLand = 1; // ���� ���� ���̷� ������� ���� �� �ִ� �ִ� ���� ��(�ƹ� ���� ���� ����� ���� ��� ������ ���� = 1)
        bfs();
        System.out.println(maxLand);
    }

    static class dot {
        int x, y;
    }
}
