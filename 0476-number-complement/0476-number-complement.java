class Solution {
    //find no of bits;
    //creation of bit mask=2^no_of_bit-1 or 1<<no_of_bits-1
    //take xor with original no
    
    public int findComplement(int num) {
        int p=num;
        int count=0;
        while(num!=0){
                num = num >> 1;
            count++;
          
        }
        int mask= (1<<count)-1;
        return p^mask;
        
    }
}
//   public int findComplement(int num) {
        
//         int numberOfBits = numberOfBits(num);
        
//         return num ^ ((1 << numberOfBits) - 1);
//     }
    
    