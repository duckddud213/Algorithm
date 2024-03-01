import java.io.*;
import java.util.*;

public class boj2953 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum, num, max;

        num = 0;
        max = 0;

        for (int i = 1; i <= 5; i++) {
            sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 4; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            if (max < sum) {
                num = i;
                max = sum;
            }
        }

        System.out.println(num + " " + max);
    }
}
