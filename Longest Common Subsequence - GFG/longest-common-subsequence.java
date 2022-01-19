// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String r, String s)
    {
        // your code here
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