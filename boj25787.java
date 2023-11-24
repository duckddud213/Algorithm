import java.io.*;
import java.util.*;

public class boj25787 {
    static int rowSum[];
    static int colSum[];
    static int crossSum[];

    static class dot {
        int x, y;
    }

    public static boolean checkBingo() {
        int cnt, i;
        cnt = 0;

        for (i = 0; i < 2; i++) {
            if (crossSum[i] == 5) {
                cnt++;
            }
        }

        for (i = 0; i < 5; i++) {
            if (rowSum[i] == 5) {
                cnt++;
            }
            if (colSum[i] == 5) {
                cnt++;
            }
        }

        if (cnt >= 3) {
            return true;
        }

        return false;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, num, x, y, cnt;

        dot[] nextInt = new dot[26];
        rowSum = new int[5];
        colSum = new int[5];
        crossSum = new int[5];

        for (i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (j = 0; j < 5; j++) {
                num = Integer.parseInt(st.nextToken());
                nextInt[num] = new dot();
                nextInt[num].x = i;
                nextInt[num].y = j;
            }
        }

        cnt = 0;
        for (i = 0; i < 5; i++) {
            StringTokenizer inp = new StringTokenizer(br.readLine());
            for (j = 0; j < 5; j++) {
                cnt++;
                num = Integer.parseInt(inp.nextToken());
                x = nextInt[num].x;
                y = nextInt[num].y;
                rowSum[x]++;
                colSum[y]++;
                if (x == y) {
                    crossSum[0]++;
                } else if (x + y == 4) {
                    crossSum[1]++;
                }
                if (checkBingo()) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }
}
