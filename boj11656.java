import java.io.*;
import java.util.*;


public class boj11656 {
    static String input;
    static TreeSet<String> postfix;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        postfix = new TreeSet<>();
        String newStr;

        for (int i = 0; i < input.length(); i++) {
            newStr = input.substring(i);
            postfix.add(newStr);
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        while (!postfix.isEmpty()) {
            System.out.println(postfix.pollFirst());
        }
    }
}
