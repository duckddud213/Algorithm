import java.io.*;
import java.util.*;

public class Main {
    static int H, W, sum;
    static int world[];

    public static void waterfall() {
        for (int i = 1; i < W - 1; i++) { // 인덱스 별 모이는 빗물. 첫, 마지막 제외
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(world[j], left);
            }

            for (int j = i + 1; j < W; j++) {
                right = Math.max(world[j], right);
            }

            if (world[i] < left && world[i] < right) {
                sum += Math.min(left, right) - world[i];
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        sum = 0;

        world = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            world[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        waterfall();
        System.out.println(sum);
    }
}