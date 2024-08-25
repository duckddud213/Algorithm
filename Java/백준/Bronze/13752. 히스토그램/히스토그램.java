import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= N; i++){
            int cnt = Integer.parseInt(br.readLine());
            for(int j = 1; j <= cnt; j++){
                sb.append("=");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}