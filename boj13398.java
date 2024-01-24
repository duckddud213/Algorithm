import java.io.*;
import java.util.*;

public class boj13398 {
    static int N, result;
    static int arr[], dp1[], dp2[];

    public static void dynamic() {
        int i;

        for (i = 1; i < N; i++) {
            dp1[i] = Integer.max(dp1[i - 1] + arr[i], arr[i]);
            result = Integer.max(result, dp1[i]);
        }

        for (i = N - 2; i >= 0; i--) {
            dp2[i] = Integer.max(dp2[i + 1] + arr[i], arr[i]);
        }

        for (i = 1; i < N - 1; i++) {
            int tmp = dp1[i - 1] + dp2[i + 1];
            result = Integer.max(result, tmp);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp1 = new int[N];
        dp2 = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = arr[0];
        dp1[0] = arr[0];
        dp2[N - 1] = arr[N - 1];
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        dynamic();
        System.out.println(result);
    }
}
