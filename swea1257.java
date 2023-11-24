import java.io.*;
import java.util.*;

public class swea1257 {
    static int x, T, K;
    static String input, output;
    static TreeSet<String> list;
    static StringBuilder sb;

    public static void showString() {
        int i, j;
        String str;

        for (i = 0; i < input.length(); i++) {
            for (j = i + 1; j <= input.length(); j++) {
                str = input.substring(i, j);
                list.add(str);
            }
        }

        for (i = 0; i < K; i++) {
            output = list.pollFirst();
        }

        if (output == null) {
            output = "none";
        }

        sb.append("#").append(x).append(" ").append(output).append('\n');
    }

    public static void pre() throws IOException {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (x = 1; x <= T; x++) {
            K = Integer.parseInt(br.readLine());
            input = br.readLine();
            list = new TreeSet<>();
            showString();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pre();

        System.out.println(sb);
    }
}