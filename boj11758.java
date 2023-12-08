import java.io.*;
import java.util.*;

public class boj11758 {
    static Dot[] stars;

    public static void 

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        stars = new Dot[3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i] = new Dot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
    }

    static class Dot {
        int x, y;

        public Dot() {
        }

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
