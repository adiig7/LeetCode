class Solution {
        private int MOD = 1_000_000_007;
    public int countOrders(int n) {
        long[][] dp = new long[n+1][n+1];
        dp[0][0] = 1;
        
        for(int unpicked = 0; unpicked <= n; unpicked++){
            for(int undel = 0; undel <= n; undel++){
                if(unpicked == 0 && undel == 0){
                    dp[unpicked][undel] = 1;
                    continue;
                }
                if(unpicked > 0)
                    dp[unpicked][undel] += unpicked* dp[unpicked-1][undel];
                if(undel > unpicked)
                    dp[unpicked][undel] += (undel - unpicked) * dp[unpicked][undel-1];
                
                dp[unpicked][undel] %= MOD;
            }
        }
        return (int)dp[n][n];
    }
}