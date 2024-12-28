import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(in.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken())*2;
      int C = Integer.parseInt(st.nextToken())*3;
 
      int[] fee = new int[101];
      for(int i=0;i<3;i++){
         st = new StringTokenizer(in.readLine());
         int start = Integer.parseInt(st.nextToken())+1;
         int end = Integer.parseInt(st.nextToken());
         for(;start<=end;start++) fee[start]++;
      }
 
      int answer = 0;
      for(int f:fee){
         if(f==1) answer += A;
         else if(f==2) answer += B;
         else if(f==3) answer += C;
      }
 
      System.out.println(answer);
   }
}