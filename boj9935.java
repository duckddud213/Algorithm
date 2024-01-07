import java.io.*;
import java.util.*;

public class boj9935 {
    static String input, bomb;
    static Stack<Character> stack;
    static StringBuilder sb;

    public static void boom() {
        int i,j;

        i=0;
        while (i < input.length()) {
            stack.add(input.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean flag = true;

                for (j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
            i++;
        }

        for (Character c : stack) {
            sb.append(c);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        bomb = br.readLine();
        
        stack = new Stack<>();
        sb = new StringBuilder();
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        boom();
        System.out.print(sb.length() != 0 ? sb : "FRULA");
    }
}
