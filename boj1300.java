import java.io.*;
import java.util.*;

public class boj1300 {
    static int N, K, left, right;

    public static void binarySearch() {
        int count;

        left = 1;
        right = K;

        while (left < right) {
            int mid = (left + right) / 2;
            count = 0;

            for (int i = 1; i <= N; i++) {
                count += Integer.min(mid / i, N);
            }

            if (K <= count) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
    }
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        //B[k] = x 일때, x보다 작거나 같은 원소의 개수가 최소 k개라는 의미
        //1 ~ N까지를 x로 나눈 몫의 합이 K랑 같은 지 확인
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        binarySearch();
        System.out.println(left);
    }
}