import java.io.*;
import java.util.*;

public class boj11000 {
    static int N,room;
    static PriorityQueue<Lecture> pqStart,pqEnd;

    public static void greedy() {
        pqEnd.add(pqStart.poll());

        while (!pqStart.isEmpty()) {
            if (pqEnd.peek().end <= pqStart.peek().start) {
                pqEnd.remove();
            }
            pqEnd.add(pqStart.poll());
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        room = 0;

        pqStart = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1,Lecture o2) {
                return o1.start - o2.start;
            }
        });

        pqEnd = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1,Lecture o2) {
                return o1.end-o2.end;
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pqStart.add(new Lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        greedy();
        System.out.println(pqEnd.size());
    }

    static class Lecture{
        int start, end;

        public Lecture() {
        }

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
