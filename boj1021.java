import java.io.*;
import java.util.*;

public class boj1021 {
    static int N, M, cnt, start;
    static int remove[];
    static List deq;

    public static void turning() {
        for (int i = 0; i < M; i++) {
            int idx = deq.indexOf(remove[i]);
            
            if (start <= idx) {
                cnt += Math.min(idx - start, deq.size() - idx + start);
            }
            else {
                cnt += Math.min(start - idx, deq.size() - start + idx);
            }
            start = idx;
            deq.remove(Integer.valueOf(remove[i]));
            if (deq.size() == 0) {
                start = 0;
            }
            else {
                start = idx % (deq.size());
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        deq = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        start = 0;

        remove = new int[M];

        for (int i = 1; i <= N; i++) {
            deq.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            remove[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        turning();
        System.out.println(cnt);
    }
}
