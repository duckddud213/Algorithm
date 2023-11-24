import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.io.BufferedReader;
import java.io.IOException;

public class boj2346 {
    public static void main(String args[]) throws IOException {
        int N;

        Deque<int[]> rQue = new ArrayDeque<int[]>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        String move[] = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            rQue.add(new int[] { i + 1, Integer.parseInt(move[i]) });
        }

        int goNext;

        while (!rQue.isEmpty()) {
            int[] pop = rQue.poll();
            goNext = pop[1];
            sb.append(pop[0] + " ");

            if (rQue.isEmpty()) {
                break;
            }

            if (goNext < 0) {
                goNext *= -1;
                for (int i = 1; i <= goNext; i++) {
                    rQue.addFirst(rQue.pollLast());
                }

            } else {
                for (int i = 1; i < goNext; i++) {
                    rQue.add(rQue.poll());
                }
            }
            for (int j = 0; j < rQue.size(); j++) {

            }
        }
        System.out.println(sb);
    }
}
