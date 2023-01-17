//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        // approach=> acquire->work->release
       ArrayList<Integer> list=new ArrayList<Integer> ();
       HashMap<Integer,Integer> hm=new HashMap<>();//hashmap of element and freq;
       for(int i=0;i<=k-2;i++ ){
           hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
       }
       int j=0;
       for(int i=k-1;i<n;i++){
           //acquire
           hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
           //work
           int numOfUnique=hm.size();
           list.add( numOfUnique);
           
           //release
           if(hm.get(arr[j])==1){
               hm.remove(arr[j]);
           }else{
              int val=hm.get(arr[j]);
               val=val-1;
               hm.put(arr[j],val);
           }
           j++;
           
           
           
       }
       return list;
    }
}

