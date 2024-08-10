import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String args[]) throws IOException{
        int N,cnt;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        HashSet<Integer> used = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(used.contains(num)){
                cnt++;
            }
            else{
                used.add(num);
            }
        }
        System.out.println(cnt);
    }
}