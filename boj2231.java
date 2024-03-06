import java.io.*;
import java.util.*;

public class boj2231 {
    static int N, result;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        result = 0;

        for (int i = 1; i <= N; i++) {
            String num = Integer.toString(i);
            int sum = i;

            for (int j = 0; j < num.length(); j++) {
                sum += Integer.parseInt(Character.toString(num.charAt(j)));
            }

            if (sum == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
