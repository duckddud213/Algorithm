import java.io.*;
import java.util.*;

public class boj4999 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String require = br.readLine();

        if (input.length() < require.length()) {
            System.out.println("no");
        }
        else {
            System.out.println("go");
        }
    }
}
