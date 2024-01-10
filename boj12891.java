import java.io.*;
import java.util.*;

public class boj12891 {
    static int S, P, cnt;
    static String str;
    static int canUse[];
    static int used[];

    public static void pre() throws IOException {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        cnt = 0;

        str = br.readLine();

        used = new int[4];
        canUse = new int[4];

        st = new StringTokenizer(br.readLine());

        for (i = 0; i < 4; i++) {
            canUse[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 윈도우 사용 개수 설정
        for (i = 0; i < P; i++) {
            if (str.charAt(i) == 'A' || str.charAt(i) == 'C' || str.charAt(i) == 'G' || str.charAt(i) == 'T') {
                used[findPos(str.charAt(i))]++;
            }
        }

        for (i = 0; i < 4; i++) {
            if (used[i] < canUse[i]) {
                break;
            }
        }

        if (i == 4) {
            cnt++;
        }

        for (i = 1; i <= S - P; i++) {
            if (str.charAt(i - 1) == 'A' || str.charAt(i - 1) == 'C' || str.charAt(i - 1) == 'G'
                    || str.charAt(i - 1) == 'T') {
                used[findPos(str.charAt(i - 1))]--;
            }

            if (str.charAt(i+P-1) == 'A' || str.charAt(i+P-1) == 'C' || str.charAt(i+P-1) == 'G' || str.charAt(i+P-1) == 'T') {
                used[findPos(str.charAt(i+P-1))]++;
            }

            for (j = 0; j < 4; j++) {
                if (used[j] < canUse[j]) {
                    break;
                }
            }

            if (j == 4) {
                cnt++;
            }
        }
    }

    public static int findPos(Character ch) {
        if (ch == 'A') {
            return 0;
        } else if (ch == 'C') {
            return 1;
        } else if (ch == 'G') {
            return 2;
        } else
            return 3;
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(cnt);
    }
}