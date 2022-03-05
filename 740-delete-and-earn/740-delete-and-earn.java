class Solution {
    public int deleteAndEarn(int[] nums) {
        int ex = 0, in = 0;
        int[] count = new int[10001];
        for(int val : nums)     count[val]++;
        
        for(int i = 0; i < 10001; i++){
            int it = ex + count[i]*i;
            int et = Math.max(ex, in);
            
            in = it;
            ex = et;
        }
        return Math.max(ex, in);
    }
}