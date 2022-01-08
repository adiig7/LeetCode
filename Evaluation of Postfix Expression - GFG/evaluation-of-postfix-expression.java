// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s)
    {
        // Your code here
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                st.push(ch - '0');
            }else{
                int op1 = st.pop();
                int op2 = st.pop();
                switch(ch){
                    case '+':
                        st.push(op1+op2);
                        break;
                    case '-':
                        st.push(op2-op1);
                        break;
                    case '*':
                        st.push(op1*op2);
                        break;
                    case '/':
                        st.push(op2/op1);
                        break;
                }
            }
        }
        return st.pop();
    }
}