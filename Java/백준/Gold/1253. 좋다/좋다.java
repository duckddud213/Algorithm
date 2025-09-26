import java.io.*;
import java.util.*;

public class Main {
    static int N, result;
    static int num[];

    public static void twoPointer() {
        int l, r;

        for (int i = 0; i < N; i++) {
            l = 0;
            r = N - 1;

            while (true) {
                if (l == i) {
                    l++;
                }
                else if (r == i) {
                    r--;
                }

                if (l >= r) {
                    break;
                }

                if (num[l] + num[r] > num[i]) {
                    r--;
                }
                else if (num[l] + num[r] < num[i]) {
                    l++;
                }
                else {
                    result++;
                    break;
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        twoPointer();
        System.out.println(result);
    }
}
