//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
   /* approach
   step 1-push everyone in stack;
   step 2-compare every two element of stack
         condition- if first knows second == it means first is not celebrity ,thus push back second(potential celebrity)
         condition- if second knows first == it means second is not celebrity, push one back (possible celebrity);
         repeat.... till stack have only one elemnt
    step 3-pop element i.e posiible celebrity.
    step 4-check it for all element if 
          condition -element row is all are zero and elements column all one except itself then it is celebrity
          else no one is celebrity.
   */
    int celebrity(int arr[][], int n)
    {
    	Stack<Integer> stk=new Stack<>();
    	for(int i=0;i<n;i++){
    	    stk.push(i);
    	}
    	while(stk.size()>=2){
    	    int a=stk.pop();
    	    int b=stk.pop();
    	    //if a knows b then b is celebrity, a is not celebrity
    	    if(arr[a][b]==1){
    	        stk.push(b);
    	    }
    	    //if b knows a then a is celebrity, b is not celebrity
    	    else{
    	        stk.push(a);
    	    }
    	}
    	//last elemnet present in stack is possible celeb
    	int potential_celeb=stk.pop();
    	//checking row 
    	for(int i=0;i<arr[0].length;i++){
    	   if (arr[potential_celeb][i]!=0){
    	        return -1;
    	    }
    	}
    	//checking coulumn
    		for(int i=0;i<n;i++){
    		    if(i==potential_celeb){
    		        continue;
    		    }
    	    if(arr[i][potential_celeb]==0){
    	        return -1;
    	    }
    	}
    	return potential_celeb;
    }
}