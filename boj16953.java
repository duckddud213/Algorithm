import java.io.*;
import java.util.*;

public class boj16953 {
    static int A, B, cnt;

    public static boolean valid(int a) {
        if (a % 10 == 3 || a % 10 == 5 || a % 10 == 7 || a % 10 == 9) {
            return false; // B를 변환해도 A로 절대 도달할수 없는 경우
        }
        return true;
    }

    public static void backCal(int src, int dest) {
        if (src == dest) {
            System.out.println(cnt + 1);
            return;
        } else if (src < dest || !valid(src)) {
            System.out.println(-1);
            return;
        }

        cnt++;
        if (src % 10 == 1) {
            backCal(src / 10, dest);
        } else {
            backCal(src / 2, dest);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        cnt = 0;
    }

    public static void main(String args[]) throws IOException {
        pre();
        backCal(B, A);
    }
}
