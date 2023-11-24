import java.io.*;
import java.util.*;

public class boj2667 {
    static List<Integer> town;
    static int N, townCnt, townSize; // townCnt : �� ������ || townSize : ���� �� ������
    static int map[][];
    static boolean isVisited[][];
    static Deque<dot> que;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void bfs() {
        int i, j, idx, qi, qj, qix, qjy;
        isVisited = new boolean[N][N];
        que = new ArrayDeque<>();
        town = new ArrayList<>();

        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (isVisited[i][j] || map[i][j] == 0) { // �湮�� ���̰ų� ���� ���� ����� ��� ���� ���� Ž��
                    continue;
                }

                townCnt++;
                townSize = 0;

                dot newDot = new dot(); // bfs Ž�� ������ ��ǥ�� que�� �ֱ� ���� ����
                newDot.x = i;
                newDot.y = j;
                isVisited[i][j] = true;

                que.add(newDot);

                while (!que.isEmpty()) {
                    townSize++;
                    dot queDot = que.poll();
                    qi = queDot.x;
                    qj = queDot.y;

                    for (idx = 0; idx < 4; idx++) {
                        qix = qi + dx[idx];
                        qjy = qj + dy[idx];

                        // ���� �ȿ� ���Եǰ�, �湮���� ���� ������ ���� �ִ� ��� que�� ����
                        if (qix >= 0 && qix < N && qjy >= 0 && qjy < N && map[qix][qjy] == 1 && !isVisited[qix][qjy]) {
                            dot inputDot = new dot();
                            inputDot.x = qix;
                            inputDot.y = qjy;
                            isVisited[qix][qjy] = true;
                            que.addLast(inputDot);
                        }
                    }
                }

                town.add(townSize); // town ����Ʈ�� ���� ũ�� ����
            }
        }

        Collections.sort(town); // town ����Ʈ�� ����� ���� ũ�� ����
    }

    public static void main(String args[]) throws IOException {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (i = 0; i < N; i++) {
            String inp[] = br.readLine().split("");
            for (j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inp[j]);
            }
        }
        townCnt = 0;
        bfs();

        System.out.println(townCnt); // �� ������ ���
        for (int a : town) {
            System.out.println(a); // �������� ���ĵ� ���� �� ���� ���� ���
        }
    }

    static class dot {
        int x, y;
    }
}
