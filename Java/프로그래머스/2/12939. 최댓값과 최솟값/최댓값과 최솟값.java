import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        boolean first = true;
        int min,max;
        
        StringTokenizer st = new StringTokenizer(s);
        
        min = 0;
        max = 0;
        while(st.hasMoreTokens()){
            String next = st.nextToken();
            if(first){
                min = Integer.parseInt(next);
                max = Integer.parseInt(next);
                first = !first;
            }
            else{
                min = Integer.min(min, Integer.parseInt(next));
                max = Integer.max(max, Integer.parseInt(next));
            }
        }
        
        answer += (Integer.toString(min) + " " + Integer.toString(max));
        
        return answer;
    }
}