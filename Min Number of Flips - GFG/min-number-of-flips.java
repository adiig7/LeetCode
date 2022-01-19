// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution ob = new Solution();
            
            System.out.println(ob.minFlips(S));
                        
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public int minFlips(String s) {
        // Code hers
        int c1 = 0, c2 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1' && i % 2 == 1)    c1++;
            if(s.charAt(i) == '0' && i % 2 == 0)    c1++;
            if(s.charAt(i) == '1' && i % 2 == 0)    c2++;
            if(s.charAt(i) == '0' && i % 2 == 1)    c2++;
        }
        return Math.min(c1, c2);
    }
}