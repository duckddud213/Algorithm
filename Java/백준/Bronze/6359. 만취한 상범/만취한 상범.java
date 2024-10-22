import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int x = 1; x <= T; x++){
            int N = Integer.parseInt(br.readLine());
            boolean jail[] = new boolean[N + 1];
            
            for(int i = 2; i <= N; i++){
                for(int j = 1; j * i <= N; j++){
                    jail[i * j] = !jail[i * j];
                }
            }
            
            int cnt = 0;
            for(int i = 1; i <= N; i++){
                if(!jail[i]){
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}