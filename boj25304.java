import java.io.*;
import java.util.*;

public class boj25304 {
    static int N;
    static long X,sum;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        X = Long.parseLong(br.readLine());
        N = Integer.parseInt(br.readLine());
        sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sum += (a * b);
        }

        if (X == sum) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
