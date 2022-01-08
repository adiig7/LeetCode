// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().infixToPostfix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to convert an infix expression to a postfix expression.
	public static String infixToPostfix(String s) 
	{
		// Your code here
		Stack<Character> st = new Stack<>();
		String res="";
		for(int i = 0; i < s.length(); i++){
		    char ch = s.charAt(i);
		    if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
		        res += ch;
		    else if(ch == '(')
		        st.push('(');
		    else if(ch == ')'){
		        while(!st.empty() && st.peek() != '(')
		           res += st.pop();
		        if(!st.empty())
		            st.pop();
		    }else{
		        while(!st.empty() && prec(st.peek()) >= prec(ch))
		            res += st.pop();
		        st.push(ch);
		    }
		}
		while(!st.empty())
		    res += st.pop();
		return res;
	} 
	static int prec(char ch){
	    if(ch == '+'|| ch == '-')
	        return 1;
	   else if(ch == '/' || ch == '*')
	       return 2;
	   else if(ch == '^')
	        return 3;
	   else
	        return -1;
	}
	
}