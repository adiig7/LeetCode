// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
    public int romanToDecimal(String str) {
        // code here
        int res = 0;
        for(int i = 0; i < str.length(); i++){
            int s1 = value(str.charAt(i));
            if(str.length() > i+1){
                int s2 = value(str.charAt(i+1));
                if(s1 >= s2)
                    res += s1;
                else{
                    res += s2 - s1;
                    i++;
                }
            }else
                res += s1;
        }
        return res;
    }
}