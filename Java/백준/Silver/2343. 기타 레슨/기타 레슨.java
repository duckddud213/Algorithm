import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
 
      int[] lec = new int[N];
      int min = 1, max = 1;//min : 원소 중 최댓값, max : 모든 원소의 합
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
         lec[i] = Integer.parseInt(st.nextToken());
         max += lec[i];
         min = Math.max(min,lec[i]);
      }
 
      int mid, sum, count;
      while(min<=max){
         mid = (min+max)/2;
         count = 1;
         sum = 0;
         for(int l:lec){
            sum += l;
            if(sum > mid){
               sum = l;
               count++;
            }
         }
 
         if(count>M){
            min = mid+1;
         }else{
            max = mid-1;
         }
      }
 
      System.out.println(min);
   }
}