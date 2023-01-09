//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
class Pair {
int val = 0;
int min = 0;

Pair(int val, int min) {
this.val = val;
this.min = min;
}
}

Stack<Pair> st = new Stack<>();


// TC: O(1), SC: O(1)
void push(int x) {
// Write Code here
if (st.size() == 0) {
st.push(new Pair(x, x));
} else {
int myMin = Math.min(x, st.peek().min);
st.push(new Pair(x, myMin));
}
}

// TC: O(1), SC: O(1)
int pop() {
// Write Code here
if (st.size() == 0) {
return -1;
} else {
return st.pop().val;
}
}

// TC: O(1), SC: O(1)
int getMin() {
// Write Code here
if (st.size() == 0) {
return -1;
}

return st.peek().min;
}
}

// Approach 3 TC: O(1) for each operation, SC: O(N)

