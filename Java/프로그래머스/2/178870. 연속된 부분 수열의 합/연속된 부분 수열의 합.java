import java.io.*;
import java.util.*;

class Solution {
    static int answer[];
    
    public static void twopointer(int seq[], int k){
        int l, r, size, sum;
        
        l = 0;
        r = 0;
        size = seq.length;
        sum = seq[l];
        
        while(l < size && r < size && l <= r){
            // System.out.println(l + " " + r + " " + sum);
            if(sum > k){
                sum -= seq[l];
                l++;
            }
            else if(sum < k){
                r++;
                if(r < size){
                    sum += seq[r];
                }
                else{
                    return;
                }
            }
            else{
                if(answer[0] == Integer.MAX_VALUE && answer[1] == Integer.MAX_VALUE){
                    //초기 상태일때
                    answer[0] = l;
                    answer[1] = r;
                }
                else if(r - l < answer[1] - answer[0]){
                    answer[0] = l;
                    answer[1] = r;
                }
                else if(l < answer[0]){
                    answer[0] = l;
                    answer[1] = r;
                }
                
                r++;
                if(r < size){
                    sum += seq[r];
                }
            }
        }        
    }
    
    public int[] solution(int[] sequence, int k) {
        answer = new int[2];
        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MAX_VALUE;
        
        twopointer(sequence, k);
        
        return answer;
    }
}