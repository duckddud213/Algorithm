import java.io.*;
import java.util.*;

public class Main {
    static int r, c, m, result;
    static int map[][];
    static HashMap<Integer, Shark> sharkList;

    public static int moving(Shark sh, int d, int type) {
        int move = sh.s;
        while (move > 0) {
            if (type == 1 || type == 2) {
                if (sh.r == 0)
                    d = 1;
                else if (sh.r == r - 1)
                    d = -1;
                sh.r += d;
            } else {
                if (sh.c == 0)
                    d = 1;
                else if (sh.c == c - 1)
                    d = -1;
                sh.c += d;
            }
            move--;
        }
        return d;
    }

    public static void fishing() {
        int pos = -1;
        for (int test = 0; test < c; test++) {
            // 1. fishing
            pos++;
            for (int i = 0; i < r; i++) {
                if (map[i][pos] > 0) {
                    int sharkNumber = map[i][pos];
                    result += sharkList.get(sharkNumber).z; // 상어 잡음
                    // 상어 제거
                    sharkList.remove(sharkNumber);
                    map[i][pos] = 0;
                    break;
                }
            }

            // 2. shark move
            for (int key : sharkList.keySet()) {
                Shark sh = sharkList.get(key);
                // d 1위 2아래 3오른쪽 4왼쪽
                map[sh.r][sh.c] = 0;
                if (sh.d == 1) {
                    // r--;
                    if (moving(sh, -1, sh.d) == 1)
                        sh.d = 2;
                } else if (sh.d == 2) {
                    // r++;
                    if (moving(sh, 1, sh.d) == -1)
                        sh.d = 1;
                } else if (sh.d == 3) {
                    // c++;
                    if (moving(sh, 1, sh.d) == -1)
                        sh.d = 4;
                } else {
                    // c--;
                    if (moving(sh, -1, sh.d) == 1)
                        sh.d = 3;
                }
            }

            List<Integer> removeList = new ArrayList<>();
            // 같은 위치에 있는 상어 서로 경쟁하기
            for (int key : sharkList.keySet()) {
                Shark sh = sharkList.get(key);
                if (map[sh.r][sh.c] > 0) {
                    if (sharkList.get(map[sh.r][sh.c]).z > sh.z) {
                        removeList.add(key);
                    } else {
                        removeList.add(map[sh.r][sh.c]);
                        map[sh.r][sh.c] = key;
                    }
                } else {
                    map[sh.r][sh.c] = key;
                }
            }
            for (int key : removeList) {
                sharkList.remove(key);
            }
        }
    }

    public static void pre() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        sharkList = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharkList.put(i + 1, new Shark(y, x, s, d, z));
            map[y][x] = i + 1;
        }

        result = 0;

    }

    public static void main(String[] args) throws IOException {
        pre();
        fishing();
        System.out.println(result);
    }

    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}