public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans=0;
        for(int i=0;i<32;i++){
            ans<<=1;           // shifting ans i digit to its correct position in left
           int lastbit=n&1 ;    // finding last bit of n
            ans=ans|lastbit;   //  adding last bit to ans by or operation
            n>>=1;                // excluding last bit by moving right and checking for next left bit
            
        }
        return ans;
        
        
    }
}