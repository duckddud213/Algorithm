import java.io.*;
import java.util.*;

public class boj2981 {
    static int N, min;
    static int num[];
    static StringBuilder sb;

    public static int GCD(int a, int b) {
        int tmp1 = Integer.max(a, b);
        int tmp2 = Integer.min(a, b);

        while (tmp2 != 0) {
            int r = tmp1 % tmp2;
            tmp1 = tmp2;
            tmp2 = r;
        }
        return tmp1;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;

        num = new int[N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        int val = Math.abs(num[1] - num[0]);

        for (int i = 2; i < N; i++) {
            val = GCD(val, Math.abs(num[i] - num[i - 1]));
        }

        for (int i = 2; i <= val; i++) {
            if (val % i == 0) {
                sb.append(i).append(" ");
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
