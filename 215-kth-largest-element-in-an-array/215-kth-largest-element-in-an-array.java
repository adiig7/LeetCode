class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            if(i < k)
                pq.add(nums[i]);
            else{
                if(nums[i] > pq.peek()){
                    pq.remove();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}