import java.io.*;
import java.util.*;

public class boj2012 {
    static int N;
    static long sum;
    static int score[];

    public static void cal() {
        Arrays.sort(score);

        for (int i = 0; i < N; i++) {
            sum += Math.abs(i + 1 - score[i]);
        }
        System.out.println(sum);
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        score = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        pre();
        cal();
    }
}
