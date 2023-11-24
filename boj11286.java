import java.io.*;
import java.util.*;

public class boj11286 {
    static int N;
    static PriorityQueue<absInt> pq;
    static StringBuilder sb;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>();
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append('\n');
                } 
                else {
                    sb.append(pq.poll().num).append('\n');
                }
            } 
            else {
                pq.add(new absInt(input,Math.abs(input)));
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }

    static class absInt implements Comparable<absInt>{
        int num, absnum;

        public absInt() {
        }
        
        public absInt(int num, int absnum) {
            this.num = num;
            this.absnum = absnum;
        }

        @Override
        public int compareTo(absInt o) {
            // TODO Auto-generated method stub
            if (this.absnum == o.absnum) {
                return this.num - o.num;
            }
            return this.absnum - o.absnum;
        }

    }
}
