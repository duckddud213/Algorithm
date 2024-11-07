import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        if(num < 425){
            System.out.println("Violet");
        }
        else if(num < 450){
            System.out.println("Indigo");
        }
        else if(num < 495){
            System.out.println("Blue");
        }
        else if(num < 570){
            System.out.println("Green");
        }
        else if(num < 590){
            System.out.println("Yellow");
        }
        else if(num < 620){
            System.out.println("Orange");
        }
        else if(num <= 780){
            System.out.println("Red");
        }
    }
}