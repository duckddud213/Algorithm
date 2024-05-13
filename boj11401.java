import java.io.*;
import java.util.*;

public class boj11401 {
    static int N, K;
    static long tmp, result, temp, answer;
    static long MOD = 1000000007;

    public static long binomial(long a, long b) {
        if (b == 0 || b == 1) {
            return a;
        }

        temp = binomial(a, b / 2);
        answer = (temp * temp) % MOD;

        if ((b & 1) == 1) {
            answer = (answer * a) % MOD;
        }

        return answer;
    }

    public static void doCal() {
        result = 1;
        tmp = 1;

        for (long i = N - K + 1; i <= N; i++) {
            result = (result * i) % MOD;
        }

        for (long i = 2; i <= K; i++) {
            tmp = (tmp * i) % MOD;
        }

        tmp = binomial(tmp, MOD - 2);
        result = (result * tmp) % MOD;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // ( N | K ) = N! / K!(N - K)!
        // ( N | K ) = ( N | N - K )
        // ( N | K ) = ( N -1 | K ) + ( N - 1 | K - 1)

    }

    public static void main(String args[]) throws IOException {
        pre();
        doCal();
        System.out.println(result);
    }
}
