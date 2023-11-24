import java.io.*;
import java.util.*;

public class boj2170 {
    static int N;
    static long sum;
    static List<Line> lines;

    public static void cal() {
        Collections.sort(lines, comparator);

        int src, dest;

        src = lines.get(0).x;
        dest = lines.get(0).y;
        for (int i = 1; i < N; i++) {
            Line newLine = lines.get(i);

            if (dest >= newLine.x) { // 기존의 길이를 연장하는 경우
                dest = Math.max(newLine.y, dest);
            } else {
                sum += (dest - src);
                src = newLine.x;
                dest = newLine.y;
            }
        }
        sum += (dest - src);
        System.out.println(sum);
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        lines = new ArrayList<>();
        sum = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    public static void main(String[] args) throws IOException {
        pre();
        cal();
    }

    static class Line {
        int x, y;

        Line() {
        }

        Line(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Comparator<Line> comparator = new Comparator<>() {
        @Override
        public int compare(Line a, Line b) {
            if (a.x == b.x) {
                return a.y - b.y;
            }
            return a.x - b.x;
        }
    };
}
