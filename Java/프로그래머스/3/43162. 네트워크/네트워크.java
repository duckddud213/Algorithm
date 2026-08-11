import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static boolean isVisited[];
    static PriorityQueue<Integer> pq;
    public int solution(int n, int[][] computers) {
        answer = 0;
        isVisited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(isVisited[i]){
                continue;
            }
            
            answer++;
            pq = new PriorityQueue<>();
            pq.add(i);
            
            while(!pq.isEmpty()){
                int num = pq.poll();
                isVisited[num] = true;
                
                for(int j = 0; j < n; j++){
                    if(computers[num][j] == 1 && !isVisited[j]){
                        pq.add(j);
                    }
                }
            }
        }
        
        return answer;
    }
}