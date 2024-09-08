import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(br.readLine());
        int remain;
        if(A + B >= (price * 2)){
            remain = A + B - (price * 2);
        }
        else{
            remain = A + B;
        }
        
        System.out.println(remain);
    }
}