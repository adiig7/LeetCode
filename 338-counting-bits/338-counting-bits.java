class Solution {
    public int[] countBits(int num) {
    	int[] result = new int[num+1];
        int j=0;
        int powerValue = 1;
        for(int i=1; i<=num; i++){
            if(2*powerValue == i){
                j=0;
                powerValue = 2*powerValue;
            }
            result[i] = result[j++]+1;
        }
        return result;
    }
}
