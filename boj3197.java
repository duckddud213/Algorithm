import java.io.*;
import java.util.*;

public class boj3197 {
    static int R, C,day;
    static char lake[][];
    static Dot swan[];

    //Union-find 알고리즘 사용
    //https://4legs-study.tistory.com/94

    public static Dot findRoot(int nodeNum) { //같은 root node 탐색
        return null;
    }

    public static void union_root(int x, int y) {
        
    }


    public static void pre() throws IOException {
        int i, j,check;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        swan = new Dot[2];
        check = 0;
        day = 0;

        lake = new char[R][C];
        for (i = 0; i < R; i++) {
            String input[] = br.readLine().split("");
            for (j = 0; j < C; j++) {
                lake[i][j] = input[j].charAt(0);
                if (input[j].equals("L")) {
                    swan[check] = new Dot(i, j);
                    check++;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
    }

    static class Dot {
        int row, col;

        public Dot() {
        }

        public Dot(int R, int C) {
            this.row = R;
            this.col = C;
        }
    }
}