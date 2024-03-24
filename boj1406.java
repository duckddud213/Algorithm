import java.io.*;
import java.util.*;

public class boj1406 {
    static int M;
    static String input;
    static Stack<Character> lstack, rstack;
    static StringBuilder sb;
    
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        input = br.readLine();
        M = Integer.parseInt(br.readLine());
        lstack = new Stack<>();
        rstack = new Stack<>();
        sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            lstack.push(input.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Character comm = st.nextToken().charAt(0);

            if (comm == 'P') {
                lstack.push(st.nextToken().charAt(0));
            } else if (comm == 'B') {
                if (!lstack.isEmpty()) {
                    lstack.pop();
                }
            } else if (comm == 'L') {
                if (!lstack.isEmpty()) {
                    rstack.push(lstack.pop());
                }
            } else if (comm == 'D') {
                if (!rstack.isEmpty()) {
                    lstack.push(rstack.pop());
                }
            }
        }
        
        while (!lstack.isEmpty()) {
            rstack.push(lstack.pop());
        }
        while (!rstack.isEmpty()) {
            sb.append(rstack.pop().toString());
        }
    }
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
