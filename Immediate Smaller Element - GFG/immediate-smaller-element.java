//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().immediateSmaller(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void immediateSmaller(int arr[], int n) {
        // code here
        Stack<Integer> stk=new Stack<Integer>();
	    //int arr[]={5,6,2,3,1,7};
	   int i=0;
	   while(i<arr.length-1){
	       stk.push(arr[i]);
	       if(stk.peek()>arr[i+1]){
	           arr[i]=arr[i+1];
	       }
	       else{
	          arr[i]=-1;
	       }
	       i++;
	   }
	 arr[n-1]=-1;
        
    }
}