import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static List<Integer> num;
    static String comm;
    static StringBuilder sb;

    public static void AC() {
        boolean isReversed = false;
        for (int i = 0; i < comm.length(); i++) {
            Character command = comm.charAt(i);

            if (command == 'R') {
                isReversed = !isReversed;
            }
            else if (command == 'D') {
                if (num.isEmpty()) {
                    sb.append("error").append(("\n"));
                    return;
                }

                if (!isReversed) {
                    num.remove(0);
                }
                else {
                    num.remove(num.size() - 1);
                }
            }
        }

        if (num.isEmpty()) {
            sb.append("[]").append('\n');
            return;
        }

        sb.append("[");

        if (!isReversed) {
            for (int i = 0; i < num.size() - 1; i++) {
                sb.append(num.get(i)).append(",");
            }
            sb.append(num.get(num.size() - 1));
        }
        else {
            for (int i = num.size() - 1; i > 0; i--) {
                sb.append(num.get(i)).append(",");
            }
            sb.append(num.get(0));
        }

        sb.append("]").append("\n");
    }

    public static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            comm = br.readLine();

            N = Integer.parseInt(br.readLine());
            num = new ArrayList<>();

            String input = br.readLine();
            String newArr = input.substring(1, input.length() - 1);

            StringTokenizer st = new StringTokenizer(newArr, ",");
            for (int i = 0; i < N; i++) {
                num.add(Integer.parseInt(st.nextToken()));
            }

            AC();
        }
    }

    public static void main(String args[]) throws IOException {
        inputs();
        System.out.print(sb);
    }
}