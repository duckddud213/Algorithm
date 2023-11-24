import java.io.*;
import java.util.*;

public class boj9252 {
    static StringBuilder sb;
    static String[] str1, str2;
    static int max;
    static int match[][];

    public static void backTrack(int i, int j) {
        if (match[i][j] == 0) {
            return;
        }

        if (str1[i - 1].equals(str2[j - 1])) {
            backTrack(i - 1, j - 1);
            sb.append(str1[i - 1]);
        } 
        else {
            if (match[i - 1][j] > match[i][j - 1]) {
                backTrack(i - 1, j);
            } else {
                backTrack(i, j - 1);
            }
        }
    }

    public static void LCS() {
        int i, j;
        for (i = 0; i < str1.length; i++) {
            for (j = 0; j < str2.length; j++) {
                if (str1[i ].equals(str2[j])) {
                    match[i+1][j+1] = match[i][j] + 1;
                } else {
                    match[i+1][j+1] = Math.max(match[i+1][j], match[i][j+1]);
                }
                max = Math.max(max, match[i+1][j+1]);
            }
        }

        sb.append(max).append('\n');

        backTrack(str1.length, str2.length);

    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        max = 0;

        str1 = br.readLine().split("");
        str2 = br.readLine().split("");
        match = new int[str1.length+1][str2.length+1];

        for (int i = 0; i <= str1.length; i++) {
            for (int j = 0; j <= str2.length; j++) {
                match[i][j] = 0;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        LCS();
        System.out.println(sb);
    }
}
