import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static HashSet<Integer> set;
    static StringBuilder sb;
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        set = new HashSet<>();
        sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String mod = st.nextToken();

            if (mod.equals("add")) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            else if (mod.equals("check")) {
                int input = Integer.parseInt(st.nextToken());
                if (set.contains(input)) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
            else if (mod.equals("remove")) {
                int remove = Integer.parseInt(st.nextToken());
                if (set.contains(remove)) {
                    set.remove(remove);
                }
            }
            else if (mod.equals("toggle")) {
                int input = Integer.parseInt(st.nextToken());
                if (set.contains(input)) {
                    set.remove(input);
                } else {
                    set.add(input);
                }
            }
            else if (mod.equals("all")) {
                for (int num = 1; num <= 20; num++) {
                    set.add(num);
                }
            }
            else if (mod.equals("empty")) {
                set.clear();
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}