import java.io.*;
import java.util.*;

public class boj2845 {
    static int N, M;
    static StringBuilder sb;
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        int num = N * M;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int person = Integer.parseInt(st.nextToken());

            sb.append(person - num).append(" ");
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
