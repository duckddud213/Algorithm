import java.io.*;
import java.util.*;

public class boj4008 {
    static int N, F, A, B, C;
    static int dp[], soldier[], presum[];

    public static void pre() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[N+1];
        soldier = new int[N+1];
        presum = new int[N+1];

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

    }
    
    public static void main(String args[]) throws IOException {
        System.out.println(F);
    }
}