class Solution {
    public int longestCommonSubsequence(String r, String s) {
        int[][] dp = new int[r.length()+1][s.length()+1];
        for(int i = dp.length -2; i >= 0; i--){
            for(int j = dp[0].length-2; j >= 0; j--){
                char c1 = r.charAt(i);
                char c2 = s.charAt(j);
                if(c1 == c2)
                    dp[i][j] = dp[i+1][j+1] + 1;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}