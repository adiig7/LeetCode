// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
        
        Integer nextInt(){
            return Integer.parseInt(next());
        }
    } 
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t>0)
        {
            int R = sc.nextInt();
            int C = sc.nextInt();
            
            char mat[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            String target  = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findOccurrence(mat,target));
            
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int findOccurrence(char board[][], String word)
    {
        // Write your code here
         int res = 0;
        for(int i = 0; i < board.length; i++)
            for(int j = 0;j < board[i].length; j++)
                res += search(i, j, word, board, word.length(), 0);
        return res;
    }
     public int search(int i, int j, String word, char[][] board, int size,int idx){
        int res = 0;
        if(i >= 0 && j >= 0 && i < board.length && j < board[i].length && word.charAt(idx) == board[i][j]){
            char temp = word.charAt(idx);
            board[i][j] = '0';
            idx++;
            if(idx == size){
                res = 1;
            }else{
                res+= search(i+1, j, word, board, size, idx);
                res += search(i-1, j, word, board, size, idx);
                res += search(i, j+1, word, board, size, idx);
                res += search(i, j-1, word, board, size, idx);
            }
            board[i][j] = temp;
        }
        return res;
    }
}