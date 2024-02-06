import java.io.*;
import java.util.*;

public class boj25192 {
    static int N, cnt;
    static HashSet<String> chatting;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = 0;

        chatting = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                chatting.clear();
            } 
            else if (!chatting.contains(input)) {
                cnt++;
                chatting.add(input);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(cnt);
    }
}
