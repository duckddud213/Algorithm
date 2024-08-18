import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int x = 1; x <= T; x++){
            int sum = Integer.parseInt(br.readLine());
            int option = Integer.parseInt(br.readLine());
            for(int i = 0; i < option; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sum += (a * b);
            }
            System.out.println(sum);
        }
    }
}