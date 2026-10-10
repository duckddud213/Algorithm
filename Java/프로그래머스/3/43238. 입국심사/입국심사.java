import java.io.*;
import java.util.*;

class Solution {
    static int size;
    static long answer;
    
    public static void binarySearch(int n, int times[]){
        long l, r, m;
        
        l = 0;
        r = 1000000000L * 1000000000L;
        m = (l + r) / 2;
        
        while(l < r){
            m = (l + r) / 2;
            // System.out.println(l+ " " + r + " " + m);
            long sum = 0;
            for(int t : times){
                sum += (m / t);
            }
            
            if(sum < n){
                l = m + 1;
            }
            else{
                r = m;
            }
        }
        answer = r;
    }
    
    public long solution(int n, int[] times) {
        answer = 0;
        size = times.length;
        
        binarySearch(n, times);
        
        return answer;
    }
}