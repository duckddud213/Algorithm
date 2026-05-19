import java.io.*;
import java.util.*;

class Solution {
    static int answer, size;
    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static HashSet<Integer> isChecked;
    static PriorityQueue<Integer> pq;
    
    public void bfs(int com[][]){
        for(int i = 0; i < size; i++){
            if(isChecked.contains(i)){
                continue;
            }
            
            isChecked.add(i);
            answer++;
            
            for(int j = 0; j < size; j++){
                if(com[i][j] == 1 && !isChecked.contains(j)){
                    pq.add(j);
                }
            }
            
            while(!pq.isEmpty()){
                int next = pq.poll();
                isChecked.add(next);
                for(int j = 0; j < size; j++){
                    if(!isChecked.contains(j) && com[next][j] == 1){
                        pq.add(j);
                    }
                }
            }
            
            pq.clear();
        }
    }
    
    public boolean isValid(int x, int y){
        return x >= 0 && x < size && y >= 0 && y < size;
    }
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        size = n;
        isChecked = new HashSet<>();
        pq = new PriorityQueue<>();
        
        bfs(computers);
        
        return answer;
    }
    
    static class Pos implements Comparable<Pos>{
        int i,j;
        
        public Pos(int i, int j){
            this.i = i;
            this.j = j;
        }
        
        @Override
        public int compareTo(Pos o){
            if(this.i == o.i){
                return this.j - o.j;
            }
            return this.i - o.i;
        }
    }
}