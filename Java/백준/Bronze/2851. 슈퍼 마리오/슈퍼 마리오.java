import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sum = Integer.parseInt(br.readLine());
        int result = sum;
        for(int t = 1; t < 10; t++){
            int num = Integer.parseInt(br.readLine());
            sum += num;
            if((int) Math.abs(100 - result) >= (int) Math.abs(100 - sum)){
                result = sum;
            }
        }
        System.out.println(result);
    }
}