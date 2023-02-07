//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long heights[], long p) 
    {
        int  n=heights.length;
        long minbefore[]=new long[n];
        long minafter[]=new long[n];

        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){

            while(stk.size()>0 && heights[stk.peek()]>heights[i]){
                minafter[stk.pop()]=i;
            }

            stk.push(i);
        }

        while(stk.size()>0){
             minafter[stk.pop()]=n;
        }

         for(int i=n-1;i>=0;i--){

            while(stk.size()>0 && heights[stk.peek()]>heights[i]){
                minbefore[stk.pop()]=i;
            }

            stk.push(i);
        }

        while(stk.size()>0){
             minbefore[stk.pop()]=-1;
        }
       
        long ans=0;
        for(int i=0;i<n;i++){
            long width=minafter[i]-minbefore[i]-1;
            long area=width*heights[i];
            ans=Math.max(area,ans);
        }
        return ans;
    }
        
}



