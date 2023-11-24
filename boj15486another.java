import java.io.*;
import java.util.*;

public class boj15486another {
    static int N, max;
    static Meeting plans[];

    public static void getMaxPay() {
        int i, j;
        for (i = 1; i <= N; i++) {
            j = i + plans[i].time;
            if (j <= N) {
                plans[j].sum = Math.max(plans[j].pay + plans[i].sum, plans[j].sum);
                Math.max(max, plans[j].sum);
            }
            Math.max(max, plans[i].sum);
        }
    }

    public static void pre() throws IOException {
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        plans = new Meeting[N + 1];
        max = 0;

        for (i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            plans[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
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
