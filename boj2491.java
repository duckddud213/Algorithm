import java.io.*;
import java.util.*;

public class boj2491 {
    static int N, prev, cnt, asc, desc, num;

    public static void continous() {
        if (prev > num) {
            desc++;
            if (cnt < asc) {
                cnt = asc;
            }
            asc = 1;
        } else if (prev < num) {
            asc++;
            if (cnt < desc) {
                cnt = desc;
            }
            desc = 1;
        } else {
            asc++;
            desc++;
        }

        prev = num;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i;

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        prev = Integer.parseInt(st.nextToken());
        asc = 1;
        desc = 1;
        cnt = 1;
        for (i = 1; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            continous();
        }
        if (desc > cnt) {
            cnt = desc;
        }
        if (asc > cnt) {
            cnt = asc;
        }
        System.out.println(cnt);
    }
}
