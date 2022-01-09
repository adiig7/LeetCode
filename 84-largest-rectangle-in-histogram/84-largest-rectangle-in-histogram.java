class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] right = rightBoundary(heights);
        int[] left = leftBoundary(heights);
        for(int i = 0; i < right.length; i++)
            System.out.println(right[i]);
        System.out.println("abc");
        for(int i = 0; i < left.length; i++)
            System.out.println(left[i]);
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int width = right[i] - left[i] - 1;
            int area = width * heights[i];
            if(area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
    public int[] rightBoundary(int[] heights){
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[heights.length];
        for(int i = heights.length-1; i >= 0; i--){
        while(!st.empty()){
            if(heights[st.peek()] >= heights[i])
                st.pop();
            else break;
            }
            if(st.size() == 0)
                arr[i] = heights.length;
            else
                arr[i] = st.peek();   
            st.push(i);
        }
        return arr;
    }
    public int[] leftBoundary(int[] heights){
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
        while(!st.empty()){
            if(heights[st.peek()] >= heights[i])
                st.pop();
            else break;
            }
            if(st.size() == 0)
                arr[i] = -1;
            else
                arr[i] = st.peek();   
            st.push(i);
        }
        return arr;
    }
}