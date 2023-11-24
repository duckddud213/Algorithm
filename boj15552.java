import java.io.*;
import java.util.*;

public class boj15552 {
    static StringBuilder sb;
    static StringTokenizer st;
    static int T;

    public static void pre() throws IOException {
        int i,sum;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            sb.append(Integer.toString(sum)).append('\n');
        }

    }
    
    public static void main(String args[]) throws IOException{
        pre();
        System.out.println(sb);
    }
}
