import java.io.*;
import java.util.*;

public class boj7785 {
    static int N;
    static TreeSet<String> record;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String name, move;
        record = new TreeSet<>();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            move = st.nextToken();

            if (move.equals("enter")) {
                record.add(name);
            }
            else {
                record.remove(name);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        while (!record.isEmpty()) {
            System.out.println(record.pollLast());
        }
    }
}
