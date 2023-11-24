import java.io.*;
import java.util.*;

public class boj1047  {
    static List<Dot> xI, yI, wI;
    static int N, cnt, result; // cnt : �ڸ� ���� ��
    static long sum, cur_dist; // sum : �ڸ� ������ ���� ���� || cur_dist : ���� ��Ÿ���� ����µ� �ʿ��� ����
    static long heights[];

    public static void checkAll() {
        int ai, aj, bi, bj, minI, minJ, maxI, maxJ, idx, hIndex, check_cnt;

        for (ai = 0; ai < N; ai++) {
            for (bi = ai; bi < N; bi++) {
                for (aj = 0; aj < N; aj++) {
                    for (bj = aj; bj < N; bj++) {
                        minI = Math.min(Math.min(xI.get(ai).a, xI.get(bi).a), Math.min(yI.get(aj).b, yI.get(bj).b));
                        maxI = Math.max(Math.max(xI.get(ai).a, xI.get(bi).a), Math.max(yI.get(aj).b, yI.get(bj).b));
                        minJ = Math.min(Math.min(xI.get(ai).b, xI.get(bi).b), Math.min(yI.get(aj).a, yI.get(bj).a));
                        maxJ = Math.max(Math.max(xI.get(ai).b, xI.get(bi).b), Math.max(yI.get(aj).a, yI.get(bj).a));

                        cur_dist = 2 * (maxI - minI + maxJ - minJ);
                        // cur_dist ������ �ڸ� ���� ���� ���� ũ�ų� ����
                        // �ڸ� ������ �� �ּҷ�

                        heights = new long[N];
                        hIndex = 0;
                        sum = 0;
                        check_cnt = 0;
                        for (idx = 0; idx < N; idx++) { // ��Ÿ�� �ۿ� �ִ� ���� ����
                            if (isInFence(wI.get(idx).b, wI.get(idx).c, minI, minJ, maxI, maxJ)) {
                                // ��Ÿ�� �ȿ� �ִ� ������ ���
                                // �ʿ�� �߰��� ����ϱ� ���� �迭�� ����
                                heights[hIndex] = wI.get(idx).a;
                                hIndex++;
                            } else { // ��Ÿ�� �ۿ� �ִ� ������ ���
                                sum += wI.get(idx).a;
                                check_cnt++;
                            }
                        }

                        // ��Ÿ�� �ۿ� �ִ� ���������� �ȵǴ� ���
                        idx = 0;
                        while (sum < cur_dist && idx < hIndex) {
                            sum += heights[idx];
                            check_cnt++;
                            idx++;
                        }
                        cnt = Math.min(cnt, check_cnt);

                    }
                }
            }
        }
    }

    public static boolean isInFence(int i, int j, int minI, int minJ, int maxI, int maxJ) {
        if (i < minI) {
            return false;
        }
        if (i > maxI) {
            return false;
        }
        if (j < minJ) {
            return false;
        }
        if (j > maxJ) {
            return false;
        }
        return true;
    }

    public static void pre() throws IOException {
        int i, x, y, w;
        xI = new ArrayList<>();
        yI = new ArrayList<>();
        wI = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = Integer.MAX_VALUE;

        for (i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            xI.add(new Dot(x, y, w)); // x��ǥ ���� �������� ����
            yI.add(new Dot(y, x, w)); // y��ǥ ���� �������� ����
            wI.add(new Dot(w, x, y)); // ���� ���� ���� �������� ����
        }

        Collections.sort(xI);
        Collections.sort(yI);
        Collections.sort(wI);
    }

    public static void main(String args[]) throws IOException {
        pre();
        checkAll();
        System.out.println(cnt);
    }

    static class Dot implements Comparable<Dot> {
        int a, b, c;

        public Dot() {
        }

        public Dot(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Dot o) {
            if (o.a == this.a) {
                if (o.b == this.b) {
                    return o.c - this.c;
                }
                return o.b - this.b;
            }
            return o.a - this.a;
        }
    }
}
