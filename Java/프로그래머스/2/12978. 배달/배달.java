import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static int dist[];
    static boolean isVisited[];
    static int info[][];
    static PriorityQueue<Village> pq;
    public static void dijkstra(int road[][], int N){
        
        pq.add(new Village(1, 0));
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Village next = pq.poll();
            
            if(isVisited[next.num]) continue;
            
            isVisited[next.num] = true;
            
            for(int i = 1; i <= N; i++){
                if(road[next.num][i] == Integer.MAX_VALUE) continue;
                
                if(dist[next.num] + road[next.num][i] < dist[i]){
                    dist[i] = dist[next.num] + road[next.num][i];
                    pq.add(new Village(i, dist[i]));
                }
            }
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        answer = 0;
        
        dist = new int[N + 1];
        isVisited = new boolean[N + 1];
        info = new int[N + 1][N + 1];
        pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 1; i <= N; i++) {
            Arrays.fill(info[i], Integer.MAX_VALUE);
        }
        
        for(int next[] : road) {
            int a = next[0];
            int b = next[1];
            int c = next[2];
            int num = Integer.min(c, info[a][b]);
            info[a][b] = num;
            info[b][a] = num;
        }
        
        dijkstra(info, N);
        
        for(int num : dist){
            if(num <= K) answer++;
        }
        
        return answer;
    }
    
    static class Village implements Comparable<Village>{
        int num, d;
        
        public Village(int num, int d){
            this.num = num;
            this.d = d;
        }
        
        @Override
        public int compareTo(Village o){
            if(this.d == o.d){
                return this.num - o.num;
            }
            return this.d - o.d;
        }
    }
}