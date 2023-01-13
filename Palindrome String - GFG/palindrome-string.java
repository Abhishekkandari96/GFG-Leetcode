//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
     String recurr(String str,int num){
        if(num>=str.length()){
            return "";
        }
        char ch=str.charAt(num);
        String temp=recurr(str,num+1);
        return temp+ch;
        
    }
    int isPalindrome(String S) {
        // code here
        String str=recurr(S,0);
       // System.out.println(str);
        if(str.equals(S)){
            return 1;
        }
        return 0;
    }
};