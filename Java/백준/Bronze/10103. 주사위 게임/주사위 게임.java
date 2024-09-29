import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        int sum1 = 100;
        int sum2 = 100;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(a > b){
                sum2 -= a;
            }
            else if(a < b){
                sum1 -= b;
            }
        }
        System.out.println(sum1);
        System.out.println(sum2);
    }
}