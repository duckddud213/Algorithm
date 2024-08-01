import java.io.*;
import java.util.*;

class Solution {
    static long answer,row_s,row_e,col_s,col_e;
//    static long N,M,dest_x,dest_y,size,answer;
//    static int dx[] = {0,0,1,-1}; //기존 쿼리의 역방향 진행
//    static int dy[] = {1,-1,0,0}; //기존 쿼리의 역방향 진행
//    static Deque<Pos> que;
//    static HashSet<Pos> hset;
//     public static void moveBall(int queries[][]){
//         que.add(new Pos(dest_x, dest_y, size - 1));
        
//         for(int i = size - 1; i >= 0; i--){
//             int qIdx = queries[i][0];
//             int qCnt = queries[i][1];
            
//             while(!que.isEmpty()){
//                 if(que.peekFirst().cnt != i){
//                     break;
//                 }
                
//                 Pos cur = que.poll();
//                 int cx = cur.x;
//                 int cy = cur.y;
//                 // System.out.println(cx+" "+cy+" "+cur.cnt);
                
//                 if(isEdge(cx, cy, qIdx)){
//                     //현재 위치가 경계선인 경우(멈춘 가능성이 있는 경우)
//                     for(int mul = 0; mul <= qCnt; mul++){
//                         int nx = cx + (dx[qIdx] * mul);
//                         int ny = cy + (dy[qIdx] * mul);
//                         if(!hset.contains(new Pos(nx, ny, 0)) && isValid(nx,ny)){
//                             //기존에 같은 회차 이동에서 방문한적이 없는 지점인 경우만 추가
//                             que.add(new Pos(nx, ny, cur.cnt - 1));
//                             hset.add(new Pos(nx, ny, 0));
//                         }
//                     }
//                 }
//                 else{
//                     int nx = cx + (dx[qIdx] * qCnt);
//                     int ny = cy + (dy[qIdx] * qCnt);
//                     if(!hset.contains(new Pos(nx, ny, 0)) && isValid(nx,ny)){
//                         //기존에 같은 회차 이동에서 방문한적이 없는 지점인 경우만 추가
//                         que.add(new Pos(nx, ny, cur.cnt - 1));
//                         hset.add(new Pos(nx, ny, 0));
//                     }
//                 }
//             }
//             hset.clear();
//         }
        
//         answer = que.size();
//     }
    
//     public static boolean isEdge(int x, int y, int dir){
//         if(x == 0 && dir == 2){
//             return true;
//         }
//         if(x == N - 1 && dir == 3){
//             return true;
//         }
//         if(y == 0 && dir == 0){
//             return true;
//         }
//         if(y == M - 1 && dir == 1){
//             return true;
//         }
//         return false;
//     }
    
//     public static boolean isValid(int x, int y){
//         if(x >= 0 && x < N && y >= 0 && y < M){
//             return true;
//         }
//         return false;
//     }
    
    public void checkRange(int n, int m, int queries[][]){
        for(int i = queries.length -1; i >= 0; i--){
            int dir = queries[i][0];
            long cnt = queries[i][1];
            
            if(dir == 0){
                //좌->우
                if(col_s != 0){
                    col_s += cnt;
                }
                if(col_s >= m){
                    return;
                }
                
                //끝 범위는 경계에 닿거나 최대 칸수만큼 이동
                col_e = Math.min(col_e + cnt, m - 1);
            }
            else if(dir == 1){
                //우->좌
                if(col_e != m - 1){
                    col_e -= cnt;
                }
                if(col_e < 0){
                    return;
                }
                
                //끝 범위는 경계에 닿거나 최대 칸수만큼 이동
                col_s = Math.max(col_s - cnt, 0);
            }
            else if(dir == 2){
                //위->아래
                if(row_s != 0){
                    row_s += cnt;
                }
                if(row_s >= n){
                    return;
                }
                
                //끝 범위는 경계에 닿거나 최대 칸수만큼 이동
                row_e = Math.min(row_e + cnt, n - 1);
            }
            else if(dir == 3){
                //아래->위
                if(row_e != n - 1){
                    row_e -= cnt;
                }
                if(row_e < 0){
                    return;
                }
                
                //끝 범위는 경계에 닿거나 최대 칸수만큼 이동
                row_s = Math.max(row_s - cnt, 0);
            }
        }
        
        answer = (row_e - row_s + 1) * (col_e - col_s + 1);
    }
    
    public long solution(int n, int m, int x, int y, int[][] queries) {
        answer = 0;
        // size = queries.length;
        
        // N = n;
        // M = m;
        // dest_x = x;
        // dest_y = y;
        
        // que = new ArrayDeque<>();
        // hset = new HashSet<>();
        
        // moveBall(queries);
        
        //각각 시작&끝 행과 열
        row_s = x;
        row_e = x;
        col_s = y;
        col_e = y;
        checkRange(n, m, queries);
        
        return answer;
    }
    
//     static class Pos{
//         int x,y,cnt;
        
//         public Pos(int x, int y, int cnt){
//             this.x = x;
//             this.y = y;
//             this.cnt = cnt;
//         }
        
//         @Override
//         public int hashCode(){
//             return Objects.hash(x,y);
//         }
        
//         @Override
//         public boolean equals(Object o){
//             if(this.getClass() != o.getClass()){
//                 return false;
//             }
//             return (((Pos) o).x == this.x) && (((Pos) o).y == this.y); 
//         }
//     }
}