import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }

            stack.push(num);
        }

        System.out.println(stack.size());
    }
}