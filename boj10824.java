import java.io.*;
import java.util.*;

public class boj10824 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken() + st.nextToken();
        String B = st.nextToken() + st.nextToken();

        System.out.println(Long.parseLong(A)+Long.parseLong(B));
    }
}
