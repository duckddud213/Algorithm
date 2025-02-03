import java.io.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      int M = Integer.parseInt(br.readLine());
      char[] S = br.readLine().toCharArray();
 
      int answer = 0;
      int end = M-N*2-1;
      for(int start = 0;start<=end;start++){
         if(S[start]=='O') continue;
         int count = 0;
         while(start+2<M && S[start+1]=='O' && S[start+2]=='I'){
            if(++count>=N) answer++;
            start += 2;
         }
      }
 
      System.out.println(answer);
   }
}