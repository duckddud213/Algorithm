import java.util.Scanner;

public class boj1978 {
    public static void main(String args[]) {
        int N, i, j, cnt;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int arr[] = new int[N];

        for (i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int sift[] = new int[1001];

        for (i = 1; i <= 1000; i++) {
            sift[i] = 1;
        }

        sift[1] = 0;

        for (i = 2; i <= 1000; i++) {
            if (sift[i] == 1) {
                for (j = 2; j <= (1000 / i); j++) {
                    sift[i * j] = 0;
                }
            }
        }

        cnt = 0;
        for (i = 0; i < N; i++) {
            if (sift[arr[i]] == 1) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
