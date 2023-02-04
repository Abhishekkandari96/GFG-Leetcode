//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean notUnique(int arr[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=2)return true;
        }
        return false;
    }
    static int longestSubstrDistinctChars(String str)
    {
        // code here
        int unique=0;
        int start=0;
        int end=0;
        int arr[]=new int[123];
        int maxlength=0;
        
        while(end<str.length()){
            arr[str.charAt(end)]++;
            if(arr[str.charAt(end)]==1){
                unique++;
            }
            
            while(notUnique(arr) && start<=end){
                arr[str.charAt(start)]--;
                start++;
                
            }
             maxlength=Math.max(maxlength,end-start+1);
            end++;
            
            
        }
        return maxlength;
        
    }
}