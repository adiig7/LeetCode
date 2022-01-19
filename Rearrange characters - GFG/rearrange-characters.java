// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}// } Driver Code Ends


public class Pair{
    char ch;
    int freq;
    public Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution
{
	public static String rearrangeCharacters(String s) {
	
		//code here
		int n = s.length();
		int i,j;
		char[] ch = s.toCharArray();
		HashMap<Character, Integer> hs = new HashMap<>();
		char first;
        int fvalue=0;
		
		for(i=0;i<n;i++){
		    if(hs.containsKey(ch[i]))
		        hs.put(ch[i], hs.get(ch[i])+1);
		    else
		        hs.put(ch[i], 1);
		        
		    if(fvalue<hs.get(ch[i])){
		        fvalue = hs.get(ch[i]);
		        first = ch[i];
		    }
		}
		
		List<Map.Entry<Character, Integer> > list
            = new LinkedList<Map.Entry<Character, Integer> >(
                hs.entrySet());
 
        // Sort the list using lambda expression
        Collections.sort(
            list,
            (i1,
             i2) -> i1.getValue().compareTo(i2.getValue()));
 
        // put data from sorted list to hashmap
        HashMap<Character, Integer> tmp
            = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            tmp.put(aa.getKey(), aa.getValue());
        }
                
                
        char []res = new char[n];
        
        int val=0;
        
        if(fvalue>(n-fvalue+1))
            return "-1";
        else{
            i = 0;
            j= 1;
            
            for (char key : tmp.keySet()) {

                val = tmp.get(key);
                
                while(val!=0 && i<n){
                    res[i] = key;
                    //System.out.println(res[i]+" "+key+" "+i);
                    i += 2;
                    val--;
                    
                }
                while(val!=0 && j<n){
                    res[j] = key;
                    //System.out.println(res[j]+" "+key+" "+j);
                    j += 2;
                    val--;
                }
            }
            
        }
        
        return String.valueOf(res);
	}
}