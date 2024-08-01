import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        String input = br.readLine();
        int acnt = 0;
        int bcnt = 0;

        for (int i = 0; i < size; i++) {
            if (input.charAt(i) == 'A') {
                acnt++;
            }
            else {
                bcnt++;
            }
        }

        if (acnt > bcnt) {
            System.out.println("A");
        }
        else if (acnt < bcnt) {
            System.out.println("B");
        }
        else {
            System.out.println("Tie");
        }
    }
}
