class Solution {
    static int answer,n;
    public int solution(int[][] triangle) {
        answer = 0;
        n = triangle.length;
        
        int dp[][] = new int[n][n];
        
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < n; i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            dp[i][i] = triangle[i][i] + dp[i-1][i-1];
                
            for(int j = 1; j < i; j++){
                dp[i][j] = triangle[i][j] + Integer.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }
        
        for(int i = 0; i < n; i++){
            answer = Integer.max(answer, dp[n-1][i]);
        }
        
        return answer;
    }
}