import java.io.*;
import java.util.*;

public class boj2003 {
    static int N, M, pi, pj,cnt,sum;
    static int arr[];

    public static void twopointer() {
        sum = arr[1];
        while (pi <= N) {
            System.out.println(pi + " " + pj + " " + sum);
            if (sum > M) {
                if (pi > pj) {
                    pj = pi;
                    sum = arr[pj];
                }
                else {
                    sum -= arr[pi];
                    pi++;
                }
            }
            else if (sum < M) {
                pj++;
                if (pj == N + 1) {
                    return;
                } 
                else {
                    sum += arr[pj];
                }
            }
            else {
                System.out.println("here! "+pi+" "+pj);
                cnt++;
                pj++;
                if (pj == N + 1) {
                    return;
                }
                else {
                    sum += arr[pj];
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pi = 1;
        pj = 1;
        cnt = 0;
        sum = 0;
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        twopointer();
        System.out.println(cnt);
    }
}