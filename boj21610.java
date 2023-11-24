import java.io.*;

public class boj21610 {
    static int dirX[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
    static int dirY[] = { 0, 0, 1, 1, 1, 0, -1, -1, -1 };
    static int N, M;
    static int land[][];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j;

        String inp[] = br.readLine().split(" ");
        N = Integer.parseInt(inp[0]);
        M = Integer.parseInt(inp[1]);

        land = new int[N][N];

        for (i = 0; i < N; i++) {
            String inp1[] = br.readLine().split(" ");
            for (j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(inp1[j]);
            }
        }

    }

    private class cloud {
        int x, y, d, s;

        cloud(int x, int y, int d, int s) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;

        }
    }

}
