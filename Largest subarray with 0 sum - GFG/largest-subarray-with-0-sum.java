//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        // {15,-2,2,-8,1,7,10,23}
        
        HashMap<Integer,Integer> hm=new HashMap<>();//sum, index
        hm.put(0,-1);//putting zero sum for edge case
        int maxLength=0;
        int  sum=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            if(hm.containsKey(sum)){
                int length=i-hm.get(sum);
                maxLength=Math.max(length,maxLength);
            }else{
                hm.put(sum,i);
            }
        }
        return maxLength;
        
    }
}