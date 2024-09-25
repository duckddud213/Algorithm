import java.util.*;

class Solution {
    static int answer, min, max, len, time, end;
    public static int calculate(int t, int cores[]){ 
        if (t == 0) {
            return len;
        }
 
        int count = len;
 
        for(int i = 0; i < len; i++){
            count += (t / cores[i]);
        }
 
        return count;
    }
    
    public int solution(int n, int[] cores) {
        answer = 0;
        min = 0;
        max = 10000 * n;
        len = cores.length;
        time = 0;
        end = 0;
 
        while (true) {  
            int m = (min + max)/2;
            int count = calculate(m, cores);
 
            if(min>max){
                break;
            }
            
            if (count >= n) { // 해당시간까지 처리한 작업량보다 n이 크면 time과 m갱신
                max = m - 1;   
                time = m;     
                end = count; 
            }
            else{
                min = m + 1;
            }
        }
 
        end -= n; // 처리한 작업량과 n의 차이 갱신
        for(int i = len - 1; i >= 0; i--){
            if (time % cores[i] == 0) { 
                if (end == 0) {
                    answer = i+1;
                    break;
                }
                end--;
            }
        }
 
        return answer;
    }
}
