import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        if(A + B + C >= 100){
            System.out.println("OK");
        }
        else{
            if(A < B && A < C){
                System.out.println("Soongsil");
            }
            else if(B < A && B < C){
                System.out.println("Korea");
            }
            else{
                System.out.println("Hanyang");
            }
        }
    }
}