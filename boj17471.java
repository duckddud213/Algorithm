import java.io.*;
import java.util.*;

public class boj17471 {
    static int N;
    static int pop[]; //인구수 저장 배열

    public static void pre() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pop = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            pop[i]=Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String args[])throws IOException{
        pre();
    }
}