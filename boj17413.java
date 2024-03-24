import java.io.*;
import java.util.*;

public class boj17413 {
    static String input;
    static Stack<Character> stack;
    static StringBuilder sb;
    static boolean isTag;
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        stack = new Stack<>();
        sb = new StringBuilder();
        isTag = false;

        for (int i = 0; i < input.length(); i++) {
            Character next = input.charAt(i);
            if (next == ' ' || next == '<') {
                while (!stack.isEmpty()) {
                    sb.append(Character.toString(stack.pop()));
                }
                if (next == '<') {
                    isTag = true;
                }
                sb.append(Character.toString(next));
            } 
            else if (next == '>') {
                sb.append(Character.toString('>'));
                isTag = false;
            } 
            else if (!isTag) {
                stack.push(next);
            }
            else {
                sb.append(Character.toString(next));
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(Character.toString(stack.pop()));
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
