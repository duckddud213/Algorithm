import java.io.*;
import java.util.*;

public class boj2447 {
    static int N;
    static char square[][];

    public static void IHateStar(int srcI, int srcJ, int destI, int destJ) {
        int idx, i, j;

        if (srcI + 3 != destI && srcJ + 3 != destJ) {
            idx = 0;
            for (i = srcI; i < destI; i += ((destI - srcI) / 3)) {
                for (j = srcJ; j < destJ; j += ((destJ - srcJ) / 3)) {
                    idx++;
                    if (idx == 5) {
                        continue;
                    }

                    IHateStar(i, j, i + ((destI - srcI) / 3), j + ((destJ - srcJ) / 3));
                }
            }
        } else {
            idx = 0;
            for (i = srcI; i < srcI + 3; i++) {
                for (j = srcJ; j < srcJ + 3; j++) {
                    idx++;
                    if (idx == 5) {
                        continue;
                    }
                    square[i][j] = '*';
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        square = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                square[i][j] = ' ';
            }
        }

        IHateStar(0, 0, N, N);

        for (int i = 0; i < N; i++) {
            sb.append(square[i]).append('\n');
        }
        System.out.println(sb);
    }
}
