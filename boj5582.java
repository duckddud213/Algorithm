import java.io.*;
import java.util.*;

public class boj5582 {
    static String input1, input2;
    static int max;
    static int dp[][];

    public static void dynamic() {
        int i, j;

        for (i = 1; i <= input1.length(); i++) {
            for (j = 1; j <= input2.length(); j++) {
                if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input1 = br.readLine();
        input2 = br.readLine();
        max = 0;

        dp = new int[input1.length() + 1][input2.length() + 1];
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        dynamic();
        System.out.println(max);
    }
}
