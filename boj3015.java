import java.io.*;
import java.util.*;

public class boj3015 {
    static int N, H, savedSize;
    static long cnt;
    static Stack<Person> stack;

    public static void checkPair() {
        if (stack.isEmpty()) {
            stack.add(new Person(H,savedSize));
            return;
        }
        
        if (stack.peek().height > H) {
            cnt++;
            stack.add(new Person(H, savedSize));
        }
        else if (stack.peek().height == H) {
            savedSize +=stack.peek().size;
            cnt += stack.peek().size;
            stack.pop();
            checkPair();
        }
        else {
            cnt += stack.peek().size;
            stack.pop();
            checkPair();
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = 0;

        stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            H = Integer.parseInt(br.readLine());
            savedSize = 1;
            checkPair();
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(cnt);
    }

    static class Person {
        int height, size;

        public Person() {
        }

        public Person(int height, int size) {
            this.height = height;
            this.size = size;
        }
    }
}
