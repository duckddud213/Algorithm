import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result;
    static HashMap<Integer, Integer> ladder;
    static HashMap<Integer, Integer> snake;
    static Deque<Player> board;

    public static void playGame() {
        board.add(new Player(1, 0));

        while (!board.isEmpty()) {
            Player cur = board.poll();

            if (cur.num == 100) {
                result = cur.rollCnt;
                return;
            }
            
            boolean flag = false;
            for (int i = 6; i >= 1; i--) {
                int idx = cur.num + i;

                if (ladder.containsKey(idx)) {
                    board.add(new Player(ladder.get(idx), cur.rollCnt + 1));
                    continue;
                }
                if (snake.containsKey(idx)) {
                    board.add(new Player(snake.get(idx), cur.rollCnt + 1));
                    continue;
                }
                if (idx == 100) {
                    board.add(new Player(idx, cur.rollCnt + 1));
                    break;
                }
                if (!flag) {
                    board.add(new Player(idx, cur.rollCnt + 1));
                    flag = true;
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ladder = new HashMap<>();
        snake = new HashMap<>();
        board = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            ladder.put(src, dest);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            snake.put(src, dest);
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        playGame();
        System.out.println(result);
    }

    static class Player implements Comparable<Player> {
        int num, rollCnt;

        public Player(int num, int rollCnt) {
            this.num = num;
            this.rollCnt = rollCnt;
        }

        @Override
        public int compareTo(Player o) {
            if (this.rollCnt == o.rollCnt) {
                return o.num - this.num;
            }
            return this.rollCnt - o.rollCnt;
        }
    }
}