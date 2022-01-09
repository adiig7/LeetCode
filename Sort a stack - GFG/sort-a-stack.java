// { Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		reverse(s);
		return s;
	}
	void insert_at_correct(Stack<Integer> s, int x){
	    if(s.size() == 0 || s.peek() < x)
	        s.push(x);
	    else{
	        int temp = s.pop();
	        insert_at_correct(s, x);
	        s.push(temp);
	    }
	}
	void reverse(Stack<Integer> s){
	    if(s.size() > 0){
	        int x = s.pop();
	        reverse(s);
	        insert_at_correct(s,x);
	    }
	}
}