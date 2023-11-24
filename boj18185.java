import java.io.*;
import java.util.*;

public class boj18185 {
    static int N,cost;
    static int ramen[];

    public static void greedy() {
        int i,tmp;

        for (i = 1; i <= N; i++) {
            if (ramen[i + 1] > ramen[i + 2]) {
                //�ι�° ����� ����°���� ��� ���
                //7�� ���Ÿ� �ִ��� �ϱ� ���� �ּ������� 5�� ���Ÿ� ��
                tmp = Math.min(ramen[i], ramen[i + 1] - ramen[i + 2]);
                cost += (5 * tmp);
                ramen[i] -= tmp;
                ramen[i + 1] -= tmp;

                tmp = Math.min(ramen[i], Math.min(ramen[i + 1], ramen[i + 2]));
                cost += (7 * tmp);
                ramen[i] -= tmp;
                ramen[i + 1] -= tmp;
                ramen[i + 2] -= tmp;
            } else {
                //�ι�° ����� ����°���� �� ���
                //7�� ���Ÿ� �ִ��� �� �� 5�� ���Ÿ� ��
                tmp = Math.min(ramen[i], ramen[i + 1]);
                cost += (7 * tmp);
                ramen[i] -= tmp;
                ramen[i + 1] -= tmp;
                ramen[i + 2] -= tmp;

                tmp = Math.min(ramen[i], ramen[i + 1]);
                cost += (5 * tmp);
                ramen[i] -= tmp;
                ramen[i + 1] -= tmp;
            }
            cost += (3 * ramen[i]);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ramen = new int[N + 3]; //N��° ������ �ѹ��� ����ϱ� ���� N+3�� ũ��� ����
        cost = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            ramen[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String args[]) throws IOException{
        pre();
        greedy();
        System.out.println(cost);
    }
}
