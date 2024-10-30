import java.io.*;
import java.util.*;

public class Main {
    static int R, C, result;
    static int dir[] = { -1, 0, 1 };
    static char map[][];

    public static boolean dfs(int x, int y) {
        for (int i = 0; i < 3; i++) {
            int nx = x + 1;
            int ny = y + dir[i];

            if (!isValid(nx, ny)) {
                continue;
            }
            if (map[ny][nx] == '.') {
                if (nx == C - 1) {
                    result++;
                    return true;
                }

                map[ny][nx] = '-';
                if (dfs(nx, ny))
                    return true;
            }

        }
        return false;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < C && y >= 0 && y < R;
    }

    public static void simulate() {
        for (int i = 0; i < R; i++) {
            dfs(0, i);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        result = 0;

        map = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        simulate();
        System.out.println(result);
    }
}