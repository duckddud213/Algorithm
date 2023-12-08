import java.io.*;
import java.util.*;

public class boj1655 {
    static int N;
    static PriorityQueue<Integer> minVal, maxVal;
    static StringBuilder sb;

    public static int checkBalance(int i, int val) {
        // int mid;

        maxVal.add(val);

        if (i == 1) {
            return maxVal.peek();
        }
        else if (i == 2) {
            minVal.add(maxVal.poll());
            return maxVal.peek();
        }
        else {
            while (maxVal.peek() > minVal.peek()) {
                minVal.add(maxVal.poll());
                maxVal.add(minVal.poll());
            }

            while (maxVal.size() - minVal.size() > 1) {
                minVal.add(maxVal.poll());
            }
        }

        return maxVal.peek();
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        maxVal = new PriorityQueue<>(Collections.reverseOrder()); // �߾Ӱ����� ���� ������ ���� �ִ���
        minVal = new PriorityQueue<>(); // �߾Ӱ����� ū ������ ���� �ּ���

        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(br.readLine());
            sb.append(checkBalance(i, val)).append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
