import java.io.*;
import java.util.*;

public class Main {
    static int[][] check;
    static int[][] answer;
    static ArrayList<Sudoku> sudoku;

    public static boolean search(int idx) {
        if (idx == sudoku.size()) {
            return true;
        }

        Sudoku cur = sudoku.get(idx);
        for (int num = 1; num <= 9; num++) {
            if ((check[0][cur.r] & 1 << num) != 0 || (check[1][cur.c] & 1 << num) != 0
                    || (check[2][cur.gridNum] & 1 << num) != 0)
                continue;

            check[0][cur.r] |= 1 << num;
            check[1][cur.c] |= 1 << num;
            check[2][cur.gridNum] |= 1 << num;
            answer[cur.r][cur.c] = num;

            if (search(idx + 1))
                return true;

            check[0][cur.r] &= ~(1 << num);
            check[1][cur.c] &= ~(1 << num);
            check[2][cur.gridNum] &= ~(1 << num);
        }
        return false;
    }

    public static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(answer[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void pre() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        check = new int[3][9];
        answer = new int[9][9];
        sudoku = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                int cur = line.charAt(j) - '0';
                int gridNum = i / 3 * 3 + j / 3;

                if (cur == 0) {
                    sudoku.add(new Sudoku(i, j, gridNum));
                    continue;
                }
                answer[i][j] = cur;
                check[0][i] |= 1 << cur;
                check[1][j] |= 1 << cur;
                check[2][gridNum] |= 1 << cur;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        pre();
        search(0);
        printAnswer();
    }

    static class Sudoku {
        int r, c, gridNum;

        public Sudoku(int r, int c, int gridNum) {
            this.r = r;
            this.c = c;
            this.gridNum = gridNum;
        }
    }
}