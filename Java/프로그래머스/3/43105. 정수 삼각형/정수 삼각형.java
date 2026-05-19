import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int dp[][] = new int[height][triangle[height - 1].length];
        
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < height; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
                else if(j == triangle[i].length - 1){
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                }
                else{
                    dp[i][j] = triangle[i][j] + Integer.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        
        int answer = 0;
        
        for(int j = 0; j < triangle[height - 1].length; j++){
            answer = Integer.max(answer, dp[height - 1][j]);
        }
        return answer;
    }
}