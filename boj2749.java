import java.io.*;
import java.util.*;

public class boj2749 {
    static long N;
    static HashMap<Long, Long> fiboMap;

    public static long fibo(long x) {
        long result = -1;

        if (fiboMap.containsKey(x)) {
            return fiboMap.get(x);
        }

        if (x % 2 == 0) {
            result = div(fibo(x / 2) * (fibo(x / 2 - 1) + fibo(x / 2 + 1)));
        } else {
            long tmp1 = div(fibo((x + 1) / 2));
            long tmp2 = div(fibo((x - 1) / 2));
            result = div(tmp1 * tmp1 + tmp2 * tmp2);
        }

        fiboMap.put(x, result);
        return result;
    }
    
    public static long div(long num) {
        return num % 1_000_000;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());
        fiboMap = new HashMap<>();

        fiboMap.put((long) 0, (long) 0);
        fiboMap.put((long) 1, (long) 1);
        fiboMap.put((long) 2, (long) 1);

        System.out.println(fibo(N));
    }
}
