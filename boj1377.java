import java.io.*;
import java.util.*;

public class boj1377 {
    static int N, result;
    static Num arr[];
    public static void sort() {
        Arrays.sort(arr);

        result = 0;

        for (int i = 0; i < N; i++) {
            result = Math.max(result, arr[i].idx - i);
        }
    }
    
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new Num[N];

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());

            arr[i] = new Num(val, i);
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        sort();
        System.out.println(result + 1);
    }

    static class Num implements Comparable<Num> {
        int num, idx;

        public Num() {
        }

        public Num(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Num o) {
            return this.num - o.num;
        }
    }
}
