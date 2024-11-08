import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String arr[] = {"204", "207", "302", "B101", "303", "501", "105"};
        
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            if(input.equals("Algorithm")){
                sb.append(arr[0]).append('\n');
            }
            else if(input.equals("DataAnalysis")){
                sb.append(arr[1]).append('\n');
            }
            else if(input.equals("ArtificialIntelligence")){
                sb.append(arr[2]).append('\n');
            }
            else if(input.equals("CyberSecurity")){
                sb.append(arr[3]).append('\n');
            }
            else if(input.equals("Network")){
                sb.append(arr[4]).append('\n');
            }
            else if(input.equals("Startup")){
                sb.append(arr[5]).append('\n');
            }
            else if(input.equals("TestStrategy")){
                sb.append(arr[6]).append('\n');
            }
        }
        System.out.print(sb);
    }
}