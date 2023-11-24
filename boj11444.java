import java.io.*;
import java.util.*;

public class boj11444 {
    static long N;
    static HashMap<Long, Long> value;

    public static long fibo(long x) {
        long result = -1;
        long tmp1, tmp2;

        if (value.containsKey(x)) {
            return value.get(x);
        }

        if (x % 2 == 0) {
            result = div(fibo(x / 2) * (fibo(x / 2 - 1) + fibo(x / 2 + 1)));
        } else {
            tmp1 = div(fibo((x + 1) / 2));
            tmp2 = div(fibo((x - 1) / 2));
            result = div(tmp1 * tmp1 + tmp2 * tmp2);
        }

        value.put(x, result);
        return result;
    }

    public static long div(long x) {
        return x % 1000000007;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        value = new HashMap<>();

        N = Long.parseLong(br.readLine());

        value.put((long) 0, (long) 0);
        value.put((long) 1, (long) 1);
        value.put((long) 2, (long) 1);
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(fibo(N));
    }
}
