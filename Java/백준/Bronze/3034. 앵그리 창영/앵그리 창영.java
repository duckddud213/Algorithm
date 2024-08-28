import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int cross = (int) Math.sqrt(Math.pow(W,2)+Math.pow(H,2));
        
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            
            if(num <= W || num <= H || num <= cross){
                System.out.println("DA");                
            }
            else{
                System.out.println("NE");
            }
        }
    }
}