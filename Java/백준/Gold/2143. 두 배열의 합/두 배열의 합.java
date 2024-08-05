import java.io.*;
import java.util.*;

public class Main {
    static int N, M, aSize, bSize;
    static long T,cnt;
    static long arrA[], arrB[];
    static long aSum[], bSum[];

    public static void twoPointer() {
        int left = 0;
        int right = bSize - 1;
        while (left < aSize && right > -1) {
            long asv = aSum[left];
            long bsv = bSum[right];
            long sum = asv + bsv;
            if (sum == T) {
                long ac = 0, bc = 0;
                while (left < aSize && asv == aSum[left]) {
                    left++;
                    ac++;
                }

                while (right > -1 && bsv == bSum[right]) {
                    right--;
                    bc++;
                }
                cnt += ac * bc;
            }
            if (sum > T) {
                right--;
            }
            else if (sum < T) {
                left++;
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Long.parseLong(br.readLine());
        cnt = 0;

        N = Integer.parseInt(br.readLine());
        arrA = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Long.parseLong(st.nextToken());
            if (i != 0) {
                arrA[i] += arrA[i - 1];
            }
        }

        M = Integer.parseInt(br.readLine());
        arrB = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrB[i] = Long.parseLong(st.nextToken());
            if (i != 0) {
                arrB[i] += arrB[i - 1];
            }
        }

        aSize = N * (N + 1) / 2;
        bSize = M * (M + 1) / 2;
        aSum = new long[aSize];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                long a = arrA[j];
                if (i > 0){
                    a -= arrA[i - 1];
                }
                aSum[idx++] = a;
            }
        }

        bSum = new long[bSize];
        idx = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i; j < M; j++) {
                long b = arrB[j];
                if (i > 0){
                    b -= arrB[i - 1];
                }
                bSum[idx++] = b;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);
    }

    public static void main(String args[]) throws IOException {
        pre();
        twoPointer();
        System.out.println(cnt);
    }
}
