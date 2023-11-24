import java.io.*;
import java.util.*;

public class boj15486 {
    static int N, max;
    static Meeting plans[];

    public static void getMaxPay() {
        int i, j;
        for (i = 1; i <= N + 1; i++) {
            max = Math.max(max, plans[i].sum);
            j = i + plans[i].time;
            if (j <= N + 1) {
                plans[j].sum = Math.max(plans[j].sum, max + plans[i].pay);
            }
        }

        max = Math.max(max, plans[N + 1].sum);
    }

    public static void pre() throws IOException {
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        plans = new Meeting[N + 2];
        max = 0;

        for (i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            plans[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        plans[i] = new Meeting(0, 0);
    }

    public static void main(String args[]) throws IOException {
        pre();
        getMaxPay();
        System.out.println(max);
    }

    static class Meeting {
        int pay, time, sum;

        public Meeting() {
        }

        public Meeting(int time, int pay) {
            this.pay = pay;
            this.time = time;
            this.sum = 0;
        }
    }
}
