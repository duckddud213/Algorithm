import java.io.*;
import java.util.*;

public class boj1543 {
    static int cnt;
    static String input, find;

    public static void pre() throws IOException {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        find = br.readLine();
        cnt = 0;

        for (i = 0; i < input.length() - find.length()+1; i++) {
            for (j = 0; j < find.length(); j++) {
                if (input.charAt(i + j) != find.charAt(j)) {
                    break;
                }
            }

            if (j == find.length()) {
                cnt++;
                i += find.length() - 1;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(cnt);
    }
}