import java.io.*;
import java.util.*;

public class boj1644 {
    static int N, idx, cnt;
    static List<Integer> prime;
    //해쉬는 해쉬값을 사용하여 데이터값을 구별저장하기 때문에,
    //탐색 과정에서 시간적인 이득을 볼 순 있지만 해쉬값 저장을 하다보니 메모리 사용량이 많아진다!!
    // static HashSet<Integer> notPrime;
    static boolean isPrime[];

    public static void twoPointer() {
        int l, r, sum;
        
        if (N == 1) {
            cnt = 0;
            return;
        }

        l = 0;
        r = 0;
        sum = prime.get(0);

        while (l <= r) {
            if (r >= prime.size()) {
                if (sum > N) {
                    sum -= prime.get(l);
                    l++;
                    continue;
                } 
                return;
            }

            if (sum > N) {
                sum -= prime.get(l);
                l++;
            } 
            else {
                if (sum == N) {
                    cnt++;
                }
                r++;
                if (r < prime.size()) {
                    sum += prime.get(r);
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        prime = new ArrayList<>();
        // notPrime = new HashSet<>();
        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        
        // notPrime.add(1);
        isPrime[1] = false;
        cnt = 0;

        // 에라토스테네스의 체
        for (int i = 2; i <= N; i++) {
            // if (notPrime.contains(i)) {
            //     continue;
            // }

            if (!isPrime[i]) {
                continue;
            }
            prime.add(i);

            for (int j = 2; i * j <= N; j++) {
                isPrime[i * j] = false;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        twoPointer();
        System.out.println(cnt);
    }
}
