import java.io.*;
import java.util.*;

public class boj12100 {
    static int N, num, max;
    static int board[][];
    static char dir[] = { 'U', 'D', 'L', 'R' };

    public static void moveBlock(char move, int arr[][], int depth) {
        int i, j, in, idx;
        Deque<Integer> stack = new ArrayDeque<>();
        in = 0;

        if (move == 'U') {
            for (j = 0; j < N; j++) {
                for (i = 0; i < N; i++) {
                    stack.addLast(arr[i][j]);
                }

                idx = 0;

                while (!stack.isEmpty()) {
                    in = stack.poll();

                    if (in == 0) {// 꺼낸값이 0인경우=>값 당겨와야함
                        continue;
                    }

                    if (stack.isEmpty()) { // case 1 : 현재 꺼낸 값의 다음값이 null이면
                        arr[idx][j] = in;
                        idx++;
                        break;
                    } else if (stack.peek() == 0) { // case 2 : 다음 값이 0이면
                        while (!stack.isEmpty() && stack.peek() == 0) {
                            stack.remove();
                        }

                        if (stack.isEmpty()) { // case2-1 : null이면(0이 아닌 다음값이 없었으면)
                            arr[idx][j] = in;
                            idx++;
                            break;
                        } else if (in == stack.peek()) {
                            arr[idx][j] = in + stack.poll();
                            idx++;
                        } else if (in != stack.peek()) {
                            arr[idx][j] = in;
                            idx++;
                        }
                    } else if (in == stack.peek()) {
                        arr[idx][j] = in + stack.poll();
                        idx++;
                    } else if (in != stack.peek()) {
                        arr[idx][j] = in;
                        idx++;
                    }
                }
                while (idx < N) {
                    arr[idx][j] = 0;
                    idx++;
                }
            }
        }

        if (move == 'D') {
            for (j = 0; j < N; j++) {
                for (i = N - 1; i >= 0; i--) {
                    stack.addLast(arr[i][j]);
                }

                idx = N - 1;

                while (!stack.isEmpty()) {
                    in = stack.poll();

                    if (in == 0) {// 꺼낸값이 0인경우=>값 당겨와야함
                        continue;
                    }

                    if (stack.isEmpty()) { // case 1 : 현재 꺼낸 값의 다음값이 null이면
                        arr[idx][j] = in;
                        idx--;
                        break;
                    } else if (stack.peek() == 0) { // case 2 : 다음 값이 0이면
                        while (!stack.isEmpty() && stack.peek() == 0) {
                            stack.remove();
                        }

                        if (stack.isEmpty()) { // case2-1 : null이면(0이 아닌 다음값이 없었으면)
                            arr[idx][j] = in;
                            idx--;
                            break;
                        } else if (in == stack.peek()) {
                            arr[idx][j] = in + stack.poll();
                            idx--;
                        } else if (in != stack.peek()) {
                            arr[idx][j] = in;
                            idx--;
                        }
                    } else if (in == stack.peek()) {
                        arr[idx][j] = in + stack.poll();
                        idx--;
                    } else if (in != stack.peek()) {
                        arr[idx][j] = in;
                        idx--;
                    }
                }
                while (idx >= 0) {
                    arr[idx][j] = 0;
                    idx--;
                }
            }
        }

        if (move == 'L') {
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    stack.addLast(arr[i][j]);
                }

                idx = 0;

                while (!stack.isEmpty()) {
                    in = stack.poll();

                    if (in == 0) {// 꺼낸값이 0인경우=>값 당겨와야함
                        continue;
                    }

                    if (stack.isEmpty()) { // case 1 : 현재 꺼낸 값의 다음값이 null이면
                        arr[i][idx] = in;
                        idx++;
                        break;
                    } else if (stack.peek() == 0) { // case 2 : 다음 값이 0이면
                        while (!stack.isEmpty() && stack.peek() == 0) {
                            stack.remove();
                        }

                        if (stack.isEmpty()) { // case2-1 : null이면(0이 아닌 다음값이 없었으면)
                            arr[i][idx] = in;
                            idx++;
                            break;
                        } else if (in == stack.peek()) {
                            arr[i][idx] = in + stack.poll();
                            idx++;
                        } else if (in != stack.peek()) {
                            arr[i][idx] = in;
                            idx++;
                        }
                    } else if (in == stack.peek()) {
                        arr[i][idx] = in + stack.poll();
                        idx++;
                    } else if (in != stack.peek()) {
                        arr[i][idx] = in;
                        idx++;
                    }
                }
                while (idx < N) {
                    arr[i][idx] = 0;
                    idx++;
                }
            }

        }

        if (move == 'R') {
            for (i = 0; i < N; i++) {
                stack.clear();
                for (j = N - 1; j >= 0; j--) {
                    stack.addLast(arr[i][j]);
                }

                idx = N - 1;

                while (!stack.isEmpty()) {
                    in = stack.poll();

                    if (in == 0) {// 꺼낸값이 0인경우=>값 당겨와야함
                        continue;
                    }

                    if (stack.isEmpty()) { // case 1 : 현재 꺼낸 값의 다음값이 null이면
                        arr[i][idx] = in;
                        idx--;
                        break;
                    } else if (stack.peek() == 0) { // case 2 : 다음 값이 0이면
                        while (!stack.isEmpty() && stack.peek() == 0) {
                            stack.remove();
                        }

                        if (stack.isEmpty()) { // case2-1 : null이면(0이 아닌 다음값이 없었으면)
                            arr[i][idx] = in;
                            idx--;
                            break;
                        } else if (in == stack.peek()) {
                            arr[i][idx] = in + stack.poll();
                            idx--;
                        } else if (in != stack.peek()) {
                            arr[i][idx] = in;
                            idx--;
                        }
                    } else if (in == stack.peek()) {
                        arr[i][idx] = in + stack.poll();
                        idx--;
                    } else if (in != stack.peek()) {
                        arr[i][idx] = in;
                        idx--;
                    }
                }
                while (idx >= 0) {
                    arr[i][idx] = 0;
                    idx--;
                }
            }
        }
    }

    public static void backTracking(char move, int arr[][], int depth) {
        int i, j, idx;
        int nextArr[][] = new int[N][N];

        if (depth > 5) {
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    if (max < arr[i][j]) {
                        max = arr[i][j];
                    }
                }
            }
            return;
        }

        for (i = 0; i < N; i++) {
            nextArr[i] = Arrays.copyOf(arr[i], N);
        }

        if (move != 'X') {
            moveBlock(move, nextArr, depth);
        }

        for (idx = 0; idx < 4; idx++) {
            backTracking(dir[idx], nextArr, depth + 1);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = Integer.MIN_VALUE;
    }

    public static void main(String[] args) throws IOException {
        pre();
        backTracking('X', board, 0);
        System.out.println(max);
    }
}