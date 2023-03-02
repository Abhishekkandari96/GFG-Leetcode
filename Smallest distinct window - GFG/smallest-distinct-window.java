//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public int findSubString( String str) {
       
        int n=str.length();
        int test[]=new int[130];
        for(int i=0;i<str.length();i++){
            if(test[str.charAt(i)]==0){
                test[str.charAt(i)]++;
            }
        }
        
        int unique=0;
        for(int i=0;i<test.length;i++){
            unique+=test[i];
        }
        
        int length=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        int arr[]=new int[130];
        int countUnique=0;
        
        while(end<str.length()){
            
            arr[str.charAt(end)]++;
            
            if(arr[str.charAt(end)]==1){
                countUnique++;                      
            }
            while(start<=n-1 && countUnique==unique ){
                 length=Math.min(length,end-start+1);
                
                arr[str.charAt(start)]--;
                if( arr[str.charAt(start)]==0){
                    countUnique--;
                }
                start++;
                
            }
            
            end++;                                   
            
        }
        return length;
    }
}