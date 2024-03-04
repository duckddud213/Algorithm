import java.io.*;
import java.util.*;

public class boj2675 {
    static int x, T;
    static StringBuilder sb;
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int x = 1; x <= T; x++) {
            st = new StringTokenizer(br.readLine());

            int repeat = Integer.parseInt(st.nextToken());
            String text = st.nextToken();

            for (int i = 0; i < text.length(); i++) {
                for (int j = 0; j < repeat; j++) {
                    sb.append(text.charAt(i));
                }
            }
            sb.append('\n');
        }

    }
    
    public static void main(String args[]) throws IOException{
        pre();
        System.out.print(sb);
    }
}
