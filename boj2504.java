import java.io.*;
import java.util.*;

public class boj2504 {
    static Stack<Character> stack;
    static int result, val;
    static String input;
    static StringBuilder sb;

    public static void cal() {

        sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.add(input.charAt(i));
                val *= 2;
            } else if (input.charAt(i) == '[') {
                stack.add(input.charAt(i));
                val *= 3;
            } else if (input.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') { 
                    result = 0;
                    break;
                } else if (input.charAt(i - 1) == '(') {
                    result += val;
                }
                stack.pop();
                val /= 2;
            } else if (input.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (input.charAt(i - 1) == '[') {
                    result += val;
                }
                stack.pop();
                val /= 3;
            }
        }
        
        if (!stack.isEmpty()) {
            sb.append(0).append('\n');
        }
        else {
            sb.append(result).append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();

        result = 0;
        val = 1;
        input = br.readLine();
        cal();

        System.out.print(sb);
    }
}
