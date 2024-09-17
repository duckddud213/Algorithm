import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++){
            String num = br.readLine();
            int last = Character.getNumericValue(num.charAt(num.length() - 1));
            if(last%2==0){
                sb.append("even").append('\n');
            }
            else{
                sb.append("odd").append('\n');
            }
        }
        System.out.println(sb);
    }
}