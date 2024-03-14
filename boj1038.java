import java.io.*;
import java.util.*;

public class boj1038 {
    static int N;
    static long cnt;
    static List<Long> list;

    public static void backTracking(long num, int idx) {
        if (idx > 10) {
            return;
        }

        list.add(num);

        for (int i = 0; i < num % 10; i++) {
            backTracking((num * 10) + i, idx + 1);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = 10;

        list = new ArrayList<>();

        if (N < 11) {
            cnt = N;
        }
        else if (N > 1022) { //감소하는 수 중 최대인 9876543210이 1022번째
            cnt = -1;
        }
        else {
            for (int i = 0; i < 10; i++) {
                backTracking(i, 1);
            }
            Collections.sort(list);

            cnt = list.get(N);
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(cnt);
    }
}
