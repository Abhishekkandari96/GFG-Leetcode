class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
          int start=0;// start pointer .. it will run acc. to condition inner loop
        int end=0;// run till condition not achived
        int count=0;// count no of nice 
        int oddCount=0;// count no of odd till end point to have no of subarrays
         
         int flag=0;// to have count of sub array till end 
         while(end<nums.length){ // outer loop
            // acquire stage
            if( nums[end]%2!=0){ // if this is truee we got odd
                oddCount++;// increment the odd count
                flag=0;

            }

            // conditios check

            while(oddCount==k){ // to manipulate  start pointer

                if(nums[start]%2!=0){ //relese odd condition
                    oddCount--;
                }
                flag++;
                start++;
            }
            count=count+flag;// increment count
            end++; 
         }
         return count;
    }
}