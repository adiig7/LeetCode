// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static boolean isMerged(int[] a, int[] b, int[] merged){
        if(a.length + b.length != merged.length)
            return false;
        
        int[] m = new int[merged.length];
        int i = 0;
        for(int e : a)
            m[i++] = e;
        for(int e : b)
            m[i++] = e;
        Arrays.sort(m);
        int[] mergedCopy = Arrays.copyOf(merged, merged.length);
        Arrays.sort(mergedCopy);
        if(!Arrays.equals(m, mergedCopy))
            return false;
        
        for(i = 1; i < merged.length; i++){
            if(merged[i] > merged[(i-1)/2])
                return false;
        }
        
        return true;
    }
    
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int a[] = new int[n];
            int b[] = new int[m];
            int merged[];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            int[] copyA = Arrays.copyOf(a, a.length), copyB = Arrays.copyOf(b, b.length);
            merged = obj.mergeHeaps(a, b, n, m);
            
            boolean flag = isMerged(copyA, copyB, merged);
            System.out.println(flag ? 1 : 0);
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        int[] c = new int[n+m];
        int idx = 0;
        for(idx = 0; idx < n; idx++)
            c[idx] = a[idx];
        for(int i = 0; i < m; i++)
            c[idx++] = b[i];
        buildHeap(c, n+m);
        return c;
    }
    void buildHeap(int[] a, int n){
        for(int i = n/2-1; i >= 0; i--)
            heapify(a, n, i);
    }
    void heapify(int[] a, int n, int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i + 2;
        if(l < n && a[l] > a[largest])
            largest = l;
        if(r < n && a[r] > a[largest])
            largest = r;
        if(largest != i){
            swap(a, i, largest);
            heapify(a, n, largest);
        }
    }
     void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}