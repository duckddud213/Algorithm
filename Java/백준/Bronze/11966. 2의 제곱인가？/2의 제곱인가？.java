import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
 
        while(num!=1){
            if(num%2==1){
                System.out.println(0);
                return;
            }
            num /= 2;
        }
 
        System.out.println(1);
    }
}