import java.io.*;
import java.util.*;

public class boj11758 {
    static Dot[] stars;

    public static void counterClockWise() {
        int a = stars[0].x * stars[1].y + stars[1].x * stars[2].y + stars[2].x * stars[0].y;
        int b = stars[0].y * stars[1].x + stars[1].y * stars[2].x + stars[2].y * stars[0].x;
        int result = (a - b > 0) ? 1 : ((a - b < 0) ? -1 : 0);

        System.out.println(result);
    }

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
        counterClockWise();
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
