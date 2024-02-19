import java.io.*;
import java.util.*;

public class boj5073 {
    static StringBuilder sb;

    public static void triangle(int a, int b, int c) {
        if (a >= b + c) {
            sb.append("Invalid").append('\n');
            return;
        }

        if (a == b && b == c) {
            sb.append("Equilateral").append('\n');
            return;
        }
        else if (a == b || b == c || c == a) {
            sb.append("Isosceles").append('\n');
            return;
        }
        else if (a != b && b != c && c != a) {
            sb.append("Scalene").append('\n');
            return;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        String input = br.readLine();

        while (!input.equals("0 0 0")) {
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a > b && a > c) {
                triangle(a, b, c);
            }
            else if (b > a && b > c) {
                triangle(b, a, c);
            }
            else {
                triangle(c, a, b);
            }

            input = br.readLine();
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}
