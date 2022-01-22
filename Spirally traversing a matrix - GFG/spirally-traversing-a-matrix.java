// { Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int minr = 0, minc = 0, maxr = matrix.length-1, maxc = matrix[0].length-1;
        int tne = r*c;
        int cnt = 0;
        while(cnt < tne){
            for(int i = minr, j = minc;j <= maxc && cnt < tne; j++){
                cnt++;
                res.add(matrix[i][j]);
            }
            minr++;
             for(int i = minr, j = maxc; i <= maxr&& cnt < tne; i++){
                cnt++;
                res.add(matrix[i][j]);
            }
            maxc--;
             for(int i = maxr, j = maxc; j >= minc && cnt < tne; j--){
                cnt++;
                res.add(matrix[i][j]);
            }
            maxr--;
            for(int i = maxr, j = minc; i >= minr && cnt < tne; i--){
                cnt++;
                res.add(matrix[i][j]);
            }
            minc++;
        }
              return res;
      }
}
