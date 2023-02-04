//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
         
         int arr[]=new int[123];
         for(int i=0;i<a.length();i++){
             arr[a.charAt(i)]++;
         }
         
         int brr[]=new int[123];
          for(int i=0;i<b.length();i++){
             brr[b.charAt(i)]++;
         }
         for(int i=0;i<123;i++){
             if(arr[i]!=brr[i]) return false;
         }
         return true;
         
         
     
    }
}