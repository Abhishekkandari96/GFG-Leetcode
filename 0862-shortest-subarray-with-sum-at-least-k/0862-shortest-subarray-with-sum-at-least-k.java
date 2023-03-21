class Solution {
    
    //https://youtu.be/eWbH_j6Lgnk
    
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
         int minlength=Integer.MAX_VALUE;
		long pre[]=new long[n+1];
        pre[0]=nums[0];
        for(int i=0;i<n;i++) pre[i+1]=pre[i]+nums[i];
        
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<n+1;i++){
            
            while(dq.size()>0 && pre[i]-pre[dq.peekFirst()]>=k){
                minlength=Math.min(minlength,i-dq.peekFirst());
                dq.removeFirst();
            }
            while(dq.size()>0 && pre[i]<=pre[dq.peekLast()]){
                dq.removeLast();
            }
            
            
            dq.add(i);
        }
        
		if(minlength==Integer.MAX_VALUE) return -1;
		return minlength;
    }
}