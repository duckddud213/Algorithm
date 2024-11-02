import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) != 'C' && input.charAt(i) != 'A' && input.charAt(i) != 'M' && 
              input.charAt(i) != 'B' && input.charAt(i) != 'R' && input.charAt(i) != 'I' && 
              input.charAt(i) != 'D' && input.charAt(i) != 'G' && input.charAt(i) != 'E'){
                System.out.print(input.charAt(i));
            }
        }
    }
}