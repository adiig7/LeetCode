class Solution {
    public String longestPalindrome(String s) {
        int len = 0, min = 0, max = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0, k = i; k < dp.length; k++, j++){
                if(i == 0)
                    dp[j][k] = true;
                else if(i == 1){
                    if(s.charAt(j) == s.charAt(k))
                        dp[j][k] = true;
                    else
                        dp[j][k] = false;
                }else{
                    if((s.charAt(j) == s.charAt(k)) && dp[j+1][k-1] == true)
                        dp[j][k] = true;
                    else 
                        dp[j][k] = false;
                }
                if(dp[j][k]){
                    if((i+1) > len){
                        len = i+1;
                        min = j;
                        max = k;
                    }
                }
            }
        }
        return s.substring(min, max+1);
    }
}