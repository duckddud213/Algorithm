import java.io.*;
import java.util.*;

public class boj2018 {
    static int N, cnt;

    public static void twoPointer() {
        int l, r, sum;

        l = 1;
        r = 1;

        sum = 1;

        while (l <= r) {
            if (sum > N) {
                sum -= l;
                l++;
            }
            else if (sum < N) {
                r++;
                sum += r;
            }
            else {
                cnt++;
                r++;
                sum += r;
            }
        }
    }
    
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = 0;
    }

    public static void main(String args[]) throws IOException {
        pre();
        twoPointer();
        System.out.println(cnt);
    }
}
