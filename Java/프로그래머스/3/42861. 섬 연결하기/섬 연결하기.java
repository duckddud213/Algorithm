import java.io.*;
import java.util.*;

class Solution {
    static int answer, grpcnt, max;
    static TreeSet<Integer> island;
    static HashMap<Integer, Integer> group;
    static PriorityQueue<Bridge> pq;
    
    public static void Prim(){
        while(!pq.isEmpty()){
            Bridge next = pq.poll();
            
            int src = group.getOrDefault(next.src, max);
            int dest = group.getOrDefault(next.dest, max);
            
            if(src != max && src == dest) continue;
            
            System.out.println(next.src+" "+next.dest+" "+src+" "+dest);
            
            if(src == max && dest == max){
                //새로운 그룹화
                group.put(next.src, grpcnt);
                group.put(next.dest, grpcnt);
                
                island.add(next.src);
                island.add(next.dest);
                
                grpcnt++;
            }
            else if(src != max && dest != max){
                //서로 다른 그룹 통합
                int minNum = Integer.min(src, dest);
                int maxNum = Integer.max(src, dest);
                
                Iterator<Integer> iter = island.iterator();
                
                while(iter.hasNext()){
                    int islandNum = iter.next();
                    if(group.getOrDefault(islandNum, -1) == maxNum){
                        group.put(islandNum, minNum);
                    }
                }
            }
            else{
                //그룹 편입
                int minNum = Integer.min(src, dest);
                int maxNum = Integer.max(src, dest);
                
                group.put(next.src, minNum);
                group.put(next.dest, minNum);
                island.add(next.src);
                island.add(next.dest);
            }
            
            answer += next.dist;
        }
    }
    
    public int solution(int n, int[][] costs) {
        answer = 0;
        grpcnt = 1;
        max = Integer.MAX_VALUE;
        
        island = new TreeSet<>();
        group = new HashMap<>();
        pq = new PriorityQueue<>();
        
        for(int b[] : costs){
            int src = b[0];
            int dest = b[1];
            int dist = b[2];
            
            pq.add(new Bridge(src, dest, dist));
        }
        
        Prim();
        
        return answer;
    }
    
    static class Bridge implements Comparable<Bridge> {
        int src, dest, dist;
        
        public Bridge(int src, int dest, int dist){
            this.src = src;
            this.dest = dest;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Bridge o){
            return this.dist - o.dist;
        }
    }
}