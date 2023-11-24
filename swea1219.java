import java.io.*;
import java.util.*;

public class swea1219 {
    static int city[][];

    public static void main(String args[]) throws IOException {
        int T, road, i, j;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (T = 0; T < 10; T++) {
            city = new int[100][100];
            boolean isVisited[] = new boolean[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            road = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (i = 0; i < road; i++) {
                city[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

        }
    }
}
