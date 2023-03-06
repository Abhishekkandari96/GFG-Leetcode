//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int arr[], int size)
    {
        // your code here
        int num=arr[0]; //initialise first num
        int freq=1;      // initialise first num freq
        
        for(int i=1;i<size;i++){    // search for posible candidate
            if(arr[i]==num){        // if prev num is equal to current num , increse freq
                freq++;
            }else{
                freq--;              //else decrese freq
                if(freq==0){          // if freq became zero update num to be new candidate and increse its freq
                    num=arr[i];
                    freq=1;
                }
            }
        }
        int count=0;                  // possible candidate surety step
        for(int i=0;i<size;i++){
            if(arr[i]==num) count++;
        }
        if(count>size/2) return num;
        return -1;
        
    }
}