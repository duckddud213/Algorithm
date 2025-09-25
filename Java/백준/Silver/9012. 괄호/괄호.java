import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static String input;
    static Stack<Character> PS;
    static StringBuilder sb;

    public static void checkString() {
        int len = input.length();

        if (input.charAt(0) == ')') {
            sb.append("NO").append("\n");
            return;
        }

        PS.push(input.charAt(0));

        for (int i = 1; i < len; i++) {
            if(input.charAt(i) == '('){
                PS.push(input.charAt(i));
            }
            else{
                if(PS.size() == 0){
                    PS.push(input.charAt(i));
                }
                else if(PS.peek() == '('){
                    PS.pop();
                }
                else{
                    break;
                }
            }
        }

        if (PS.size() == 0) {
            sb.append("YES").append("\n");
        } else {
            sb.append("NO").append("\n");
        }
    }

    public static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PS = new Stack<>();
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            input = br.readLine();
            checkString();
            PS.clear();
        }
    }

    public static void main(String args[]) throws IOException {
        inputs();
        System.out.println(sb);
    }
}
