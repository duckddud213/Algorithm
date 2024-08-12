import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int x = 0; x < T; x++){
            st = new StringTokenizer(br.readLine());
            pq.clear();
            int sum = 0;
            for(int i = 0; i < 7; i++){
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 == 0){
                    pq.add(num);
                    sum += num;
                }
            }
            sb.append(sum).append(" ").append(pq.peek()).append('\n');
        }
        
        System.out.print(sb);
    }
}