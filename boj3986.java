import java.io.*;
import java.util.*;

public class boj3986 {
    static int N, cnt;
    static Deque<Character> stack;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stack = new ArrayDeque<>();
        cnt = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            stack.clear();
            stack.add(input.charAt(0));

            for (int j = 1; j < input.length(); j++) {
                if (stack.isEmpty()) {
                    stack.addLast(input.charAt(j));
                }
                else if (stack.peekLast() == input.charAt(j)) {
                    stack.removeLast();
                } 
                else {
                    stack.addLast(input.charAt(j));
                }
            }
            if (stack.isEmpty()) {
                cnt++;
            }
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(cnt);
    }
}
