import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<Integer> minq, maxq;
    public int[] solution(String[] operations) {
        int answer[] = new int[2];
        minq = new PriorityQueue<>();
        maxq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String next : operations){
            StringTokenizer st = new StringTokenizer(next);
                        
            if(st.nextToken().equals("I")){
                int num = Integer.parseInt(st.nextToken());
                minq.add(num);
                maxq.add(num);
            }
            else{
                if(Integer.parseInt(st.nextToken()) == 1){
                    if(!maxq.isEmpty()){
                        int val = maxq.poll();
                        minq.remove(val);
                    }
                }
                else{
                    if(!minq.isEmpty()){
                        int val = minq.poll();
                        maxq.remove(val);
                    }
                }
            }
            
            if(minq.isEmpty() || maxq.isEmpty()){
                minq.clear();
                maxq.clear();
            }
        }
        
        if(minq.isEmpty() || maxq.isEmpty()){
            //둘 중 하나가 빈 경우 -> 최대값 또는 최솟값만 계속 삭제한 경우 나머지 한쪽은 빈 배열
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = maxq.poll();
            answer[1] = minq.poll();
        }
        
        return answer;
    }
}