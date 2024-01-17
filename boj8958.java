import java.io.*;
import java.util.*;

public class boj8958 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int x, T,cnt,sum;

        T = Integer.parseInt(br.readLine());
        for (x = 1; x <= T; x++) {
            String input = br.readLine();
            cnt = 0;
            sum = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'X') {
                    sum += (cnt * (cnt + 1)) / 2;
                    cnt = 0;
                } else {
                    cnt++;
                }
            }
            if (cnt != 0) {
                sum += (cnt * (cnt + 1)) / 2;
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
