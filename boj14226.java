import java.io.*;
import java.util.*;

public class boj14226 {
    static int S;
    static boolean isVisited[][];
    static PriorityQueue<Emoji> que;

    public static void bfs() {
        que.add(new Emoji(1, 1, 1));
        
        while (!que.isEmpty()) {
            Emoji cur = que.poll();

            if (cur.size == S) {
                System.out.println(cur.time);
                return;
            }

            //삭제하기
            if(cur.size>1 && !isVisited[cur.size-1][cur.copied]){
                que.add(new Emoji(cur.size - 1, cur.time + 1, cur.copied));
                isVisited[cur.size - 1][cur.copied] = true;
            }
            //복사하기
            if(!isVisited[cur.size][cur.size]){
                que.add(new Emoji(cur.size, cur.time + 1, cur.size));
                isVisited[cur.size][cur.size] = true;
            }
            //붙여넣기
            if(cur.size+cur.copied<=S && !isVisited[cur.size+cur.copied][cur.size]){
                que.add(new Emoji(cur.size+cur.copied, cur.time + 1, cur.copied));
                isVisited[cur.size + cur.copied][cur.size] = true;
            }
        }
    }
    
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());
        que = new PriorityQueue<>();
        isVisited = new boolean[1001][1001];
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        bfs();
    }
    
    static class Emoji implements Comparable<Emoji> {
        int size, time, copied;

        public Emoji() {
        }

        public Emoji(int size, int time, int copied) {
            this.size = size;
            this.time = time;
            this.copied = copied;
        }

        @Override
        public int compareTo(Emoji o) {
            if (this.time == o.time) {
                return this.size - o.size;
            }
            return this.time - o.time;
        }
    }
    
    static class Icon {
        int cnt, clip;

        public Icon() {
        }

        public Icon(int cnt, int clip) {
            this.cnt = cnt;
            this.clip = clip;
        }
    }
}
