import java.io.*;
import java.util.*;

public class boj1700 {
    static int N, K, cnt;
    static List<Integer> list;
    static HashSet<Integer> hset;

    public static void greedy() {
        int max,idx;
        
        for (int i = 0; i < K; i++) {
            int num = list.get(i);
            max = Integer.MIN_VALUE;
            idx = Integer.MIN_VALUE;

            if (hset.contains(num)) {
                continue;
            }
            else if (hset.size() < N) {
                hset.add(num);
                continue;
            }

            for (int s : hset) {
                int tmp = 0;
                List<Integer> sublist = list.subList(i + 1, K);

                if (sublist.contains(s)) {
                    tmp = sublist.indexOf(s) + 1;
                } else {
                    tmp = K - i - 1;
                }

                if (tmp > max) {
                    max = tmp;
                    idx = s;
                }
            }
            
            hset.remove(idx);
            hset.add(num);
            cnt++;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = 0;

        list = new ArrayList<>();
        hset = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        greedy();
        System.out.println(cnt);
    }
}
