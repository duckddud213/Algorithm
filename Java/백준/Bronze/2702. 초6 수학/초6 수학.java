import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int x = 1; x <= T; x++){
            st = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            if(A > B){
                int tmp = A;
                A = B;
                B = tmp;
            }
            
            int div = 1;
            
            for(int i = 1; i <= A; i++){
                if(A % i == 0 && B % i == 0){
                    div = i;
                }
            }
            
            int result = (A / div) * B;
            
            sb.append(result).append(" ").append(div).append('\n');
        }
        
        System.out.println(sb);
    }
}