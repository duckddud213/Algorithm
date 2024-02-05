import java.io.*;
import java.util.*;

public class boj12919 {
    static String S, T;
    static int result;
    static Deque<Character> que;

    public static void backTracking(String origin, String toBe) {
        if (origin.equals(toBe)) {
            result = 1;
            return;
        }
        else if (origin.length() >= toBe.length()) {
            return;
        }
        
        if (toBe.charAt(toBe.length() - 1) == 'A') {
            backTracking(origin, toBe.substring(0, toBe.length() - 1));
        }
        if(toBe.charAt(0)=='B') {
            StringBuilder sb = new StringBuilder();

            sb.append(toBe);
            String next = sb.reverse().toString();
            backTracking(origin, next.substring(0, next.length() - 1));
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();
        result = -1;
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        backTracking(S, T);
        System.out.println(result != -1 ? result : 0);
    }
}
