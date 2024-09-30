import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = n * (n+1) / 2;
        
        int result = (int) (Math.pow(sum,2));
        System.out.println(sum);
        System.out.println(result);
        System.out.println(result);
        
    }
}