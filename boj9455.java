import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9455 {
    static int m, n, sum;

    public static void count(int grid[][]) {
        int i, j, k;
        // 배열의 맨 위에서 내려가면서 만나는 0의 수 = 이동횟수
        for (j = 0; j < n; j++) {
            for (i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    for (k = i + 1; k < m; k++) {
                        if (grid[k][j] == 0) {
                            sum++;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int x, T, i, j;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tc[] = br.readLine().split(" ");
        T = Integer.parseInt(tc[0]);

        for (x = 0; x < T; x++) {
            sum = 0;
            String mn[] = br.readLine().split(" ");
            m = Integer.parseInt(mn[0]);
            n = Integer.parseInt(mn[1]);

            int grid[][] = new int[m][n];

            for (i = 0; i < m; i++) {
                String lineInput[] = br.readLine().split(" ");
                for (j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(lineInput[j]);
                }
            }

            count(grid);

            System.out.println(sum);
        }
    }
}
