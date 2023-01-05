//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String S = sc.nextLine().trim();
            Solution ob = new Solution();
            if(ob.valid(S))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean valid(String str) 
    { 
        // code here
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(stk.isEmpty()||str.charAt(i)=='(' ||str.charAt(i)=='{' || str.charAt(i)=='[' ){
                stk.push(str.charAt(i));
            }
            // else if(stk.isEmpty()&&str.charAt(i)==')' ||str.charAt(i)=='}' ||str.charAt(i)==']' ){
            //     return false;
            // }
            else{
                if((stk.peek()=='(' && str.charAt(i)!=')')||(stk.peek()=='{' && str.charAt(i)!='}')||(stk.peek()=='[' && str.charAt(i)!=']') ){
                    return false;
                }
                else{
                    stk.pop();
                }
            }
        }
        if(stk.isEmpty()){
            return true;
        }
        return false;
    }
} 