class Solution {
    public int numTeams(int[] rating) {
        int[] dp = new int[rating.length];
        int count = 0;
        
        for(int i = 0; i < rating.length; i++){
            for(int j = i; j >= 0; j--){
                if(rating[i] > rating[j]){
                        dp[i]++;
                        count += dp[j];
                }
            }
        }
        dp = new int[rating.length];
        
        for(int i = 0; i < rating.length; i++){
            for(int j = i; j >= 0; j--){
                if(rating[i] < rating[j]){
                        dp[i]++;
                        count += dp[j];
                }
            }
        }
        return count;
    }
}