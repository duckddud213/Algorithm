import java.io.*;
import java.util.*;

public class boj10988{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int ans = 1;

        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);

            if (c != input.charAt(input.length() - i - 1)) {
                ans = 0;
                break;
            }
        }
        
        System.out.println(ans);
    }
}