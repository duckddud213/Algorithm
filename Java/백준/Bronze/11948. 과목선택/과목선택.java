import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        
        
        sum += (A + B + C + D + E +F);
        
        sum -= Math.min(A,Math.min(B,Math.min(C,D)));
        sum -= Math.min(E,F);
        
        System.out.println(sum);
    }
}