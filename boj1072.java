import java.io.*;
import java.util.*;

public class boj1072 {
    static long x, y, z;
    static long src, dest, mid, ratio;

    public static void binarySearch() {
        mid = 0;
        ratio = 0;
        while (src <= dest) {
            mid = (src + dest) / 2;
            ratio = (y + mid) * 100 / (x + mid);

            if (ratio > z) {
                dest = mid - 1;
            } 
            else {
                src = mid + 1;
            }
        }
    }


    public static void pre() throws IOException {
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        z = y * 100 / x;
        if (z >= 99) {
            src = -1;
        }
        else {
            src = 1;
            dest = x;
            binarySearch();
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(src);
    }
}
