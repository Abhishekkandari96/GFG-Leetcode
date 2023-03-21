/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stk=new Stack<>();
        ListNode dummy=head;
        while(dummy!=null){
            
            while(stk.size()>0 && dummy.val>stk.peek().val ){
                stk.pop();
            }
            stk.push(dummy);
            dummy=dummy.next;
        }
        ListNode dummy2=new ListNode(5);
        ListNode temp=dummy2;
        while(stk.size()>0){
            temp.next=stk.pop();
            temp=temp.next;
        }
        temp.next=null;
       
        
        ListNode curr=dummy2.next;
        ListNode pre=null;
        ListNode follo=curr;
        
        while(curr!=null){
           
            follo=follo.next;
			curr.next=pre;
			pre=curr;
			curr=follo;

        }
        return pre;
        
        
        
    }
}