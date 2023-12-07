import java.io.*;
import java.util.*;

public class boj2110 {
    static int N, C,distance;
    static List<Integer> house;

    public static void binarySearch() {
        int l, r, m,prev,cnt;
        l = 0;
        r = house.get(house.size() - 1);

        while (l <= r) {
            m = (l + r) / 2;
            cnt = 1;
            prev = house.get(0);
            for (int i = 1; i <= house.size() - 1; i++) {
                if (house.get(i) - prev >= m) {
                    cnt++;
                    prev = house.get(i);
                }
            }

            if (cnt >= C) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        distance = r;

    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            house.add(a);
        }

        Collections.sort(house);
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        binarySearch();
        System.out.println(distance);
    }
}