import java.io.*;
import java.util.*;

public class boj2630 {
    static int N, sum, white, blue;
    static int paper[][];

    public static void cut(int srcI, int srcJ, int destI, int destJ) {
        int midI, midJ;
        midI = (srcI + destI) / 2;
        midJ = (srcJ + destJ) / 2;
        if (srcI == destI && srcJ == destJ) {
            return;
        }

        System.out.println(srcI + " " + srcJ + " " + destI + " " + destJ);
        if (paper[srcI][srcJ] != paper[srcI][midJ - 1]) {
            cut(srcI, srcJ, midI, midJ);
        } else {
            if (paper[srcI][srcJ] == 1) {
                blue++;
            } else {
                white++;
            }
        }

        if (paper[srcI][midJ] != paper[srcI][destJ - 1]) {
            cut(srcI, midJ, midI, destJ);
        } else {
            if (paper[srcI][midJ] == 1) {
                blue++;
            } else {
                white++;
            }
        }

        if (paper[midI][srcJ] != paper[midI][midJ - 1]) {
            cut(midI, srcJ, midI, midJ);
        } else {
            if (paper[midI][srcJ] == 1) {
                blue++;
            } else {
                white++;
            }
        }

        if (paper[midI][midJ] != paper[midI][destJ - 1]) {
            cut(midI, midJ, midI, destJ);
        } else {
            if (paper[midI][midJ] == 1) {
                blue++;
            } else {
                white++;
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        white = 0;
        blue = 0;

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        pre();
        cut(0, 0, N, N);
        System.out.println(white);
        System.out.print(blue);
    }
}
