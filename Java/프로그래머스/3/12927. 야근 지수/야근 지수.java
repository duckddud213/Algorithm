import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    static long answer;
    static PriorityQueue<Integer> pq;
    public long solution(int n, int[] works) {
        answer = 0;
        
        pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : works){
            pq.add(num);
        }
        
        for(int i = 0; i < n; i ++){
            int time = pq.poll();
            
            if(time == 0){
                //야근시간보다 작업량이 적은 경우
                return 0;
            }
            
            pq.add(time - 1);
        }
        
        while(!pq.isEmpty()){
            int remain = pq.poll();
            answer += (remain * remain);
        }
        
        return answer;
    }
}