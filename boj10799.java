import java.io.*;
import java.util.*;

public class boj10799 {
    static int cnt;
    static String input;
    static Stack<Character> stack;

    public static void cutting() {

        for (int i = 0; i < input.length(); i++) {
            Character cur = input.charAt(i);

            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }

            if (cur == ')') {
                stack.pop();
                if (input.charAt(i - 1) != ')') {
                    cnt += stack.size();
                } else {
                    cnt += 1;
                }
            } 
            else {
                stack.push(cur);
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cnt = 0;
        input = br.readLine();

        stack = new Stack<>();
    }

    public static void main(String args[]) throws IOException {
        pre();
        cutting();
        System.out.println(cnt);
    }
}
