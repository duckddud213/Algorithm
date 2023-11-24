import java.util.*;

public class boj18511 {
    public static void main(String args[]) {
        int N, K,i,tmp;

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        K = sc.nextInt();

        int set[] = new int[K];

        for (i = 0; i < K; i++) {
            set[i] = sc.nextInt();
        }

        for (i = 0; i < K; i++) {
            for (int j = i + 1; j < K; j++) {
                if (set[i] > set[j]) {
                    tmp = set[i];
                    set[i] = set[j];
                    set[j] = tmp;
                }
            }
        }

        tmp = 100000000;

        while (N / tmp == 0) {
            tmp /= 10;
        }

        for (i = K - 1; i >= 0; i--) {
            if (set[i] < (N / tmp)) {
                sb.append(set[i]);
                break;
            }
        }

        tmp /= 10;
        while (tmp >= 1) {
            sb.append(set[K - 1]);
            tmp /= 10;    
        }
        System.out.println(sb);
    }   
}
