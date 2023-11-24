import java.io.*;
import java.util.*;

public class boj3190 {
    static int N, K, L, sec, dir;
    static int[][] board;
    static int dx[] = { 1, 0, -1, 0 }; // 순서대로 down,right,up,left
    static int dy[] = { 0, 1, 0, -1 };
    static Deque<dot> snake;
    static List<dot> apple;
    static Deque<dot> turn;
    static boolean eatApple;

    public static void moveStart() {
        int idx;

        dir = 1;// 오른쪽 방향 시작
        while (true) {
            eatApple = false;
            sec++;

            if (meetWall(snake.peekFirst().i + dx[dir], snake.peekFirst().j + dy[dir])) { // 다음 움직이는 방향에 벽이 있는 경우
                return;
            }
            for (dot body : snake) {
                if (body.i == snake.peekFirst().i + dx[dir] && body.j == snake.peekFirst().j + dy[dir]) { // 몸과 부딪히는경우
                    return;
                }
            }

            dot snakeHead = new dot(snake.peekFirst().i + dx[dir], snake.peekFirst().j + dy[dir]); // 뱀 머리부분에 새로운 지역 추가
            snake.addFirst(snakeHead);

            idx = 0;
            for (dot a : apple) {
                if (a.i == snake.peek().i && a.j == snake.peek().j) { // 뱀 머리에 추가된 부분이 사과였을 경우
                    eatApple = true;
                    apple.remove(idx);
                    break;
                }
                idx++;
            }

            if (eatApple == false) { // 사과를 먹은게 아니면 꼬리 칸 비움
                snake.removeLast();
            }

            if (!turn.isEmpty() && turn.peekFirst().sec == sec) { // x초가 지나 방향 전환을 해야하는 경우
                if (turn.peek().dir == 'L') {
                    dir++;
                    dir %= 4;
                } else {
                    dir--;
                    if (dir == -1) {
                        dir = 3;
                    }
                }
                turn.removeFirst();
            }
        }
    }

    public static boolean meetWall(int a, int b) {
        if (a < 0) {
            return true;
        }
        if (a >= N) {
            return true;
        }
        if (b < 0) {
            return true;
        }
        if (b >= N) {
            return true;
        }
        return false;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        sec = 0;

        board = new int[N][N];
        apple = new ArrayList<>();
        snake = new ArrayDeque<>();
        turn = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dot newApple = new dot(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            apple.add(newApple);
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dot newTurn = new dot(0, 0, Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
            turn.addLast(newTurn);
        }

        dot newSnake = new dot(0, 0);
        snake.add(newSnake);
    }

    public static void main(String args[]) throws IOException {
        pre();
        moveStart();
        System.out.println(sec);
    }

    static class dot {
        int i, j, sec;
        char dir;

        public dot() {
        }

        public dot(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public dot(int i, int j, int sec, char dir) {
            this.i = i;
            this.j = j;
            this.sec = sec;
            this.dir = dir;
        }
    }

}
