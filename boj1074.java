import java.io.*;
import java.util.*;

public class boj1074 {
    static int N, r, c, cnt;
    static boolean found;

    public static void recur(int srcI, int srcJ, int destI, int destJ) {
        int midI, midJ, i, j;
        if (found) {
            return;
        }

        midI = (srcI + destI) / 2;
        midJ = (srcJ + destJ) / 2;

        if (srcI + 2 != destI && srcJ + 2 != destJ) {
            if (r < midI && c < midJ) {
                recur(srcI, srcJ, midI, midJ);
            } else if (r < midI && c < destJ) {
                cnt += (int) (Math.pow((destI - srcI), 2) * 0.25);
                recur(srcI, midJ, midI, destJ);
            } else if (r < destI && c < midJ) {
                cnt += (int) (Math.pow((destI - srcI), 2) * 0.5);
                recur(midI, srcJ, destI, midJ);
            } else if (r < destI && c < destJ) {
                cnt += (int) (Math.pow((destI - srcI), 2) * 0.75);
                recur(midI, midJ, destI, destJ);
            }
        } else {
            for (i = srcI; i <= srcI + 1; i++) {
                for (j = srcJ; j <= srcJ + 1; j++) {
                    if (found) {
                        return;
                    }
                    if (r == i && c == j) {
                        found = true;
                        return;
                    }
                    cnt++;
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cnt = 0;
        found = false;
    }

    public static void main(String[] args) throws IOException {
        pre();
        recur(0, 0, (int) Math.pow(2, N), (int) Math.pow(2, N));
        System.out.println(cnt);
    }
}
