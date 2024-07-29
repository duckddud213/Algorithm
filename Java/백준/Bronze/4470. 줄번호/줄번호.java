import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            String input = br.readLine();
            sb.append(i).append(". ").append(input).append('\n');
        }
        System.out.print(sb);
    }
}