class Solution {
    
    //  https://youtu.be/Mf-uj5LAMPgbest source to explain
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int arr[]=new int[n-k+1];
        
        Deque<Integer> dq=new LinkedList<>();
        int j=0;
        for(int i=0;i<n;i++){
            
            if(dq.size()>0 && dq.peek()<i-k+1 )
                dq.removeFirst();
            
            while(dq.size()>0 && nums[dq.peekLast()]<nums[i] )
                dq.removeLast();
            
            dq.add(i);
            if(i>=k-1){
                arr[j++]=nums[dq.peekFirst()];
            }
        
        
            }
        return arr;
        
      
    }
}