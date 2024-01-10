import java.io.*;
import java.util.*;

public class boj16435 {
    static List<Integer> fruit;
    static int N, L,max;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        fruit = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        max = L;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruit.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(fruit);

        for (int i = 0; i < fruit.size() && max >= fruit.get(i); i++) {
            max++;
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(max);
    }
}
