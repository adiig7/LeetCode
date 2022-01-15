// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        //your code here
          if(n == 1)  return "1";
        if(n == 2)  return "11";
        String res = "11";
        for(int i = 3; i <= n; i++){
            String temp = "";
            res += "&";
            int count = 1;
            for(int j = 1; j < res.length(); j++){
                if(res.charAt(j) != res.charAt(j-1)){
                    temp = temp + String.valueOf(count);
                    temp += res.charAt(j-1);
                    count = 1;
                }else
                    count++;
            }
            res = temp;
        }
        return res;
    }
}
