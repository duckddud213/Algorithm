import java.io.*;
import java.util.*;

public class boj4949 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//무한루프
		while(true) {
			String input = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			
			if(input.equals(".")) break;
			
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (ch == '(' || ch == '[')
                    stack.push(ch);

                if (ch == ')') {
                    if (stack.empty()) {
                        stack.push(ch);
                        break;
                    }

                    if (stack.peek() == '(')
                        stack.pop();
                    else
                        break;
                } else if (ch == ']') {
                    if (stack.empty()) {
                        stack.push(ch);
                        break;
                    }

                    if (stack.peek() == '[')
                        stack.pop();
                    else
                        break;
                }
            }
            
			if(stack.isEmpty()) sb.append("yes").append("\n");
			else sb.append("no").append("\n");
		}
		System.out.println(sb);
	}

}