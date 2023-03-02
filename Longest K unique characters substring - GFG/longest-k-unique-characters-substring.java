//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /*
    approach-
    1)-frequency array
    2)-hashMap;
    using frequency array
    step 1- assign two pointer 
    expand=0;
    contract=0;
    step-2 declare a potential ans variable
    step 3-declare unqiue as =0; which represent unique element count
    step 4=loop start
            (1)-expention;
                    (a)-include it into frequency array;
                    (b)-if it is first of his type incremenet count
            (2)-contraction;
                    (a)-condition: while(contraction<expand && count>k),then do exclusion of start, and decrese frequency of that char till count became equal to k 
                    
            (3)-work/calculate;
    
    
    
    */
    public int longestkSubstr(String str, int k) {
        //making frequency array
        int freq[]=new int[26];
        //declare two pointers
        int expand=0;
        int contract=0;
        //declaring potential ans;
        int potentialAns=-1;
        //declare a variable to count unique char so far;
        int count=0;
        while(expand<str.length()){
            
            //step 1-expand
            freq[str.charAt(expand)-'a']++;
            if(freq[str.charAt(expand)-'a']==1){
                //increment unique count
                count++;
            }
           
            //else count will remain same
            
             //step2=work/calculate;
            
            if(count==k){
                potentialAns=Math.max(potentialAns,expand-contract+1);
            }
            
            //step 3-contraction
            while(contract<expand && count>k){
                //exclude the char at contract and decrease iyt freq;
                freq[str.charAt(contract)-'a']--;
                //check is freq of char at contract ==0, if it became zero , then decrease count
                if(freq[str.charAt(contract)-'a']==0){
                    count--;
                }
                contract++;
            }
             expand++;
            
           
            
        }
        
        return potentialAns;
        
        
    }
}