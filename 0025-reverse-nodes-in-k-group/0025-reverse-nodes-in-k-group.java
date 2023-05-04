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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        //base cases
        if(head==null|| k==1 ){
            return head;
        }
        //initialising pointers  for reversing logic
        ListNode dummy= new ListNode();
        dummy.next=head;
        ListNode curr=dummy;
        ListNode next=dummy;
        ListNode pre=dummy;
        
        //moving counter for reversal
        int count=0;
        
        //first group
        while(curr.next!=null){
            curr=curr.next;
            count++;
            
        }
        
        while(count>=k){
            //for group
            curr=pre.next;
            next=curr.next;
            
            for(int i=1;i<k;i++){
               // reverse logic for each
                curr.next=next.next;
                next.next=pre.next;
                pre.next=next;
                next=curr.next;
            }
            //updation similar to reversal of every node
            pre=curr;
            //reduce the count for reversing new group
            count=count-k;
                
        }
        return dummy.next;
        
    }
}