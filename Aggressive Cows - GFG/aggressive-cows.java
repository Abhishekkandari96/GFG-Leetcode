//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean isPossible(int arr[], int dist, int cow){
        int cpsf=1;
        int lastPosition=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[lastPosition]>=dist){
                cpsf++;
                lastPosition=i;
            }
        }
        return cpsf>=cow;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int start=1;
        int end=stalls[n-1]-stalls[0];
        int ans=-1;
      
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPossible(stalls,mid,k)){
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
        
    }
}