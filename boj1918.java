import java.io.*;
import java.util.*;

public class boj1918 {
    static String input;
    static Deque<Character> stack;
    static StringBuilder sb;

    public static void postOrder() {
        int len = input.length();

        for (int i = 0; i < len; i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                sb.append(input.charAt(i));
            } 
            else if (cal(input.charAt(i))) { // 연산자인 경우
                if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                    while (!stack.isEmpty() && stack.peekLast() != '(') {
                        sb.append(stack.pollLast());
                    }
                    stack.add(input.charAt(i));
                }
                else {
                    while (!stack.isEmpty() && (stack.peekLast() == '*' || stack.peekLast() == '/')) {
                        sb.append(stack.pollLast());
                    }
                    stack.add(input.charAt(i));
                }
            }
            else if (input.charAt(i) == '(') {
                stack.add(input.charAt(i));
            }
            else if (input.charAt(i) == ')') {
                while (!stack.isEmpty() && stack.peekLast() != '(') {
                    sb.append(stack.pollLast());
                }
                stack.removeLast();
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
    }

    public static boolean cal(Character c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }
        return false;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        stack = new ArrayDeque<>();
        sb = new StringBuilder();
    }

    public static void main(String agrs[]) throws IOException {
        pre();
        postOrder();
        System.out.print(sb);
    }
}
