class Solution {
    public int minSwaps(String s) {
        Stack<Character> stk=new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                stk.push(s.charAt(i));
                
            }else{
                if(stk.size()>0){
                    stk.pop();
                }
                else{
                    count++;
                }
            }
}
        return (count+1)/2;
         
    }
}