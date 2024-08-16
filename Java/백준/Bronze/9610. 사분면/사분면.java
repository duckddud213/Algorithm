import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int axis, q1, q2, q3, q4;
        
        axis = 0;
        q1 = 0;
        q2 = 0;
        q3 = 0;
        q4 = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if(x == 0 || y == 0){
                axis++;
                continue;
            }
            
            if(x > 0 && y > 0){
                q1++;
            }
            else if(x < 0 && y > 0){
                q2++;
            }
            else if(x < 0 && y < 0){
                q3++;
            }
            else{
                q4++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("Q1: "+q1).append('\n');
        sb.append("Q2: "+q2).append('\n');
        sb.append("Q3: "+q3).append('\n');
        sb.append("Q4: "+q4).append('\n');
        sb.append("AXIS: "+axis).append('\n');
        
        System.out.print(sb);
    }
}