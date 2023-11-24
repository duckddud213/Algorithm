import java.io.*;
import java.util.*;

public class boj16987 {
    static int N, s, w, max, cnt;
    static egg eggInfo[];

    public static void breakEgg(int depth) {
        int i, check;

        if (depth == N) {
            cnt = 0;
            for (i = 0; i < N; i++) {
                if (eggInfo[i].solid <= 0) {
                    cnt++;
                }
            }
            max = Integer.max(max, cnt);
            return;
        }

        if (eggInfo[depth].solid <= 0) { // ���� �տ� �� ����� ���� ���
            breakEgg(depth + 1); // ���� ������� �Ѿ��
        } else {
            check = 0;
            for (i = 0; i < N; i++) {
                if (i != depth && eggInfo[i].solid > 0) { // ���� �տ� �� ��� == �� ��� OR �� ����� ���� ����� ���
                    check++;
                    eggInfo[depth].solid -= eggInfo[i].weight;
                    eggInfo[i].solid -= eggInfo[depth].weight;
                    breakEgg(depth + 1);
                    eggInfo[depth].solid += eggInfo[i].weight;
                    eggInfo[i].solid += eggInfo[depth].weight;
                }
            }
            if (check == 0) {
                breakEgg(depth + 1);
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        eggInfo = new egg[N];
        max = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            egg newEgg = new egg(s, w);
            eggInfo[i] = newEgg;
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        breakEgg(0); // �� ���� ������� ���ʴ�� ��� ����
        System.out.println(max);
    }

    static class egg {
        int weight, solid;

        public egg() {
        }

        public egg(int solid, int weight) {
            this.weight = weight;
            this.solid = solid;
        }
    }
}