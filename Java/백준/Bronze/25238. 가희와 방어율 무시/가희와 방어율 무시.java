import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int def = Integer.parseInt(st.nextToken());
        int ignore = Integer.parseInt(st.nextToken());
        
        int val = (int) (def * (100 - ignore) / 100);
        
        if(val < 100){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}