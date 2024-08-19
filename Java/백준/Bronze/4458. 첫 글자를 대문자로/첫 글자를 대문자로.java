import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            String headline = input.substring(0,1).toUpperCase();
            sb.append(headline).append(input.substring(1)).append('\n');
        }
        System.out.print(sb);
    }
}