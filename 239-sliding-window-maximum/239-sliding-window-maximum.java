class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] r = new int[nums.length-k+1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            while(!q.isEmpty() && q.peek() == i-k)
                q.poll();
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i])
                q.pollLast();
            q.offer(i);
            
            if(i >= k-1)
                r[ri++] = q.peek();
        }
        for(int i = 0; i < ri; i++)
            r[i] = nums[r[i]];
        return r;
    }
}