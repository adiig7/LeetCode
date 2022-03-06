class Solution {
        int[][] dp = new int[1005][3];
    
    public int helper(int n, int eggs){
        if(dp[n][eggs] != -1)   return dp[n][eggs];
        if(n <= 1 || n == 2 || eggs == 1)    return n;
        int mini = 1000000;
        for(int i = 1; i < n; i++)
            mini = Math.min(mini, Math.max(helper(i-1, eggs-1), helper(n-i, eggs))+1);
        return  dp[n][eggs] = mini;
    }
    public int twoEggDrop(int n) {
        for(int i = 0; i < dp.length; i++)
            for(int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        return helper(n, 2);
    }
}