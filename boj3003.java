import java.io.*;
import java.util.*;

public class boj3003 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.print(1 - Integer.parseInt(st.nextToken()) + " ");
        System.out.print(1 - Integer.parseInt(st.nextToken()) + " ");
        System.out.print(2 - Integer.parseInt(st.nextToken()) + " ");
        System.out.print(2 - Integer.parseInt(st.nextToken()) + " ");
        System.out.print(2 - Integer.parseInt(st.nextToken()) + " ");
        System.out.print(8 - Integer.parseInt(st.nextToken()));
    }
}
