import java.io.*;
import java.util.*;

public class boj2903 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println((int) Math.pow(Math.pow(2, N) + 1, 2));
    }
}