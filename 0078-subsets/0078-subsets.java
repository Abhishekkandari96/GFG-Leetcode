class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> subsets=new ArrayList<>();
        for(int i=0;i<(1<<n);i++){     //determine tthe length of subset(in truth table it itterate verticle)
            List<Integer> set=new ArrayList<>();
            for(int j=0;j<n;j++){         // check for each set bit(in trueth table it itterate horizintally)
                 if ((i & (1 << j)) > 0){
                    set.add(nums[j]);
                }
            }
            subsets.add(set);
            
        } 
        return subsets;
        
    }
}