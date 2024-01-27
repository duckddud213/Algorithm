import java.io.*;
import java.util.*;

public class boj1024 {
    static long N, L;

    public static void doCal() {
        boolean flag = true;
        
        for (long i = L; i <= 100 && flag; i++) {
            long sum = nSum(i);
            long idx = 0;

            while (true) {
                if (sum == N) {
                    for (long k = 0; k < i; k++) {
                        System.out.print(idx + k + " ");
                    }
                    flag = false;
                    break;
                }

                sum += i;
                idx += 1;

                if (sum > N)
                    break;
            }
        }
        
        if (flag) {
            System.out.println(-1);
        }
    }

    public static long nSum(long num) {
        return num * (num - 1) / 2;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        L = Long.parseLong(st.nextToken());
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        doCal();
    }
}
