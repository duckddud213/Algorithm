import java.io.*;
import java.util.*;

public class boj1269 {
    static int A, B,diffSum;
    static HashSet<Integer> set;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        set = new HashSet<>();
        int cnt;

        diffSum = 0;
        cnt = 0;

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < A; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (set.contains(num)) {
                cnt++;
            }
        }

        diffSum = A + B - (2 * cnt);
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(diffSum);
    }
}
