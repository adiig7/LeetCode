// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}



// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long heights[], long n) 
    {
        // your code here
         long[] right = rightBoundary(heights);
        long[] left = leftBoundary(heights);
        long maxArea = Integer.MIN_VALUE;
        for(long i = 0; i < heights.length; i++){
            long width = right[(int)i] - left[(int)i] - 1;
            long area = width * heights[(int)i];
            if(area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
    
    public static long[] rightBoundary(long[] heights){
        Stack<Integer> st = new Stack<>();
        long[] arr = new long[heights.length];
        for(long i = heights.length-1; i >= 0; i--){
        while(!st.empty()){
            if(heights[st.peek()] >= heights[(int)i])
                st.pop();
            else break;
            }
            if(st.size() == 0)
                arr[(int)i] = heights.length;
            else
                arr[(int)i] = st.peek();   
            st.push((int)i);
        }
        return arr;
    }
    public static long[] leftBoundary(long[] heights){
        Stack<Integer> st = new Stack<>();
        long[] arr = new long[heights.length];
        for(long i = 0; i < heights.length; i++){
        while(!st.empty()){
            if(heights[st.peek()] >= heights[(int)i])
                st.pop();
            else break;
            }
            if(st.size() == 0)
                arr[(int)i] = -1;
            else
                arr[(int)i] = st.peek();   
            st.push((int)i);
        }
        return arr;
    }
}



