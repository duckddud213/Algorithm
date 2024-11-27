import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int x = 1; x <= T; x++){
            int Y = 0;
            int K = 0;
            for(int i = 1; i <= 9; i++){
                st = new StringTokenizer(br.readLine());
                Y += Integer.parseInt(st.nextToken());
                K += Integer.parseInt(st.nextToken());
            }
            
            if(Y > K){
                sb.append("Yonsei").append('\n');
            }
            else if(Y < K){
                sb.append("Korea").append('\n');
            }
            else{
                sb.append("Draw").append('\n');
            }
        }
        System.out.print(sb);
    }
}