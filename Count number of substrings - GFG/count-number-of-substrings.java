//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
     long count(String S, int K){
         
       int unique=0;
       long count=0;
      
       int start=0;
       int end=0;
       int arr[]=new int[130];
       while(end<=S.length()-1){
           
         
           arr[S.charAt(end)]++;
           if(arr[S.charAt(end)]==1){
               unique++;
           }
           
           while(unique>K){
               arr[S.charAt(start)]--;
               if(arr[S.charAt(start)]==0){
                   unique--;
               }
               start++;
           }
           count=count+end-start+1;
           end++;
           
       }
       return count;
    }
   
    long substrCount (String S, int K) {
      return count(S,K)-count(S,K-1);
    }
}