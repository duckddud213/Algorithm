import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String num1 = st.nextToken();
        String num2 = st.nextToken();

        String A = "";
        String B = "";
        String C = "";
        String D = "";

        for (int i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) == '5') {
                B += "6";
                A += "5";
            }
            else if (num1.charAt(i) == '6') {
                A += "5";
                B += "6";
            }
            else {
                A += Character.toString(num1.charAt(i));
                B += Character.toString(num1.charAt(i));
            }
        }

        for (int i = 0; i < num2.length(); i++) {
            if (num2.charAt(i) == '5') {
                D += "6";
                C += "5";
            }
            else if (num2.charAt(i) == '6') {
                C += "5";
                D += "6";
            }
            else {
                C += Character.toString(num2.charAt(i));
                D += Character.toString(num2.charAt(i));
            }
        }

        int aa = Integer.parseInt(A);
        int bb = Integer.parseInt(B);
        int cc = Integer.parseInt(C);
        int dd = Integer.parseInt(D);

        int sum1 = aa + cc;
        int sum2 = bb + dd;

        System.out.println(sum1 + " " + sum2);
    }
}