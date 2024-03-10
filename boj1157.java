import java.io.*;
import java.util.*;

public class boj1157 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().toLowerCase();

        int alpha[] = new int[26];
        PriorityQueue<Alphabet> pq = new PriorityQueue<>();

        for (int i = 0; i < input.length(); i++) {
            alpha[input.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            pq.add(new Alphabet(alpha[i], Character.toString('a' + i)));
        }

        Alphabet answer = pq.poll();
        Alphabet next = pq.poll();

        if (answer.cnt == next.cnt) {
            System.out.println("?");
        }
        else {
            System.out.println(answer.str.toUpperCase());
        }
    }

    static class Alphabet implements Comparable<Alphabet> {
        int cnt;
        String str;

        public Alphabet() {
        }

        public Alphabet(int cnt, String str) {
            this.cnt = cnt;
            this.str = str;
        }

        @Override
        public int compareTo(Alphabet alpha) {
            return alpha.cnt - this.cnt;
        }
    }
}
