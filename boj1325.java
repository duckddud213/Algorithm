import java.io.*;
import java.util.*;

public class boj1325 {
    static int N, M, a, b;
    static int income[];
    static int connect[][];

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        income = new int[N + 1]; // ���Ա��� Ȯ��
        connect = new int[N + 1][N + 1]; // �ܹ��� ���� ���� Ȯ��

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            connect[b][a] = 1; // b->a �������� ��ŷ ����
            income[b] = income[b] + income[a];
        }

        for (int i = 0; i < N; i++) {

        }
    }

    public static void main(String[] args) throws IOException {
        pre();
    }

}