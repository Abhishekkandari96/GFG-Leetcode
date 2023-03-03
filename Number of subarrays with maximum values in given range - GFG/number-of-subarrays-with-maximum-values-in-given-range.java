//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String []element = line1.trim().split(" ");
		    int n = Integer.parseInt(element[0]);
		    int l = Integer.parseInt(element[1]);
		    int r = Integer.parseInt(element[2]);
		    
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.countSubarrays(arr, n, l, r));
		        
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static long countSubarrays(int arr[], int n, int L, int R)  
    { 
        int start=0;// start pointer;
        int end=0;// end pointer;
        int count=0;// count of subarray 
        int flag=0;
        
        while(end<n){
            
            if(arr[end]>=L && arr[end]<=R){
                                        // elements are in range;
            
            flag=end-start+1;           // formula for total subarrays till end start.
            
            }
            else if(arr[end]>R){ // not in range;
            
            // make flag =0 // not coseder sub array befor this
            flag=0;
            start=end+1;
                
            }
            count=count+flag;
            
            end++;
        }
        return count;
        
    } 
}

