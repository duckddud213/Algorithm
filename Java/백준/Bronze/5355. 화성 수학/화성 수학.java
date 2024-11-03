import java.io.*;
import java.util.*;

public class Main{
    public static double cal(double num, char c){
        if(c == '@'){
            return num * 3;
        }
        else if(c == '%'){
            return num + 5;
        }
        else{
            return num - 7;
        }
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for(int x = 1; x <= T; x++){
            st = new StringTokenizer(br.readLine());
            double num = Double.parseDouble(st.nextToken());
            
            while(st.hasMoreTokens()){
                num = cal(num, st.nextToken().charAt(0));
            }
            System.out.printf("%.2f",num);
            System.out.println();
        }
    }
}