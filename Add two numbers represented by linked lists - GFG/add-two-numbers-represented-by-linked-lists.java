//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node Reverse(Node head){
       Node curr=head;
       Node follow=head;
       Node pre=null;
        while(curr!=null){
            follow=follow.next;
            curr.next=pre;
            pre=curr;
            curr=follow;
        }
        return pre;
    }
    static Node addTwoLists(Node head1, Node head2){
        // code here
        // return head of sum list
        Node temp1=Reverse(head1);
        Node temp2=Reverse(head2);
        Node out=new Node(0);
        Node temp3=out;
        int sum=0; 
        int carry=0;
        while(temp1!=null || temp2!=null){
            sum=0;
            
        if(temp1!=null){
            sum=sum+temp1.data;
              temp1=temp1.next;
        }
         if(temp2!=null){
            sum=sum+temp2.data;
             temp2=temp2.next;
         }
        sum=sum+carry;
        carry=sum/10;
        temp3.next=new Node(sum%10);
        temp3=temp3.next;
        }
        if(carry>0){
             temp3.next=new Node(carry);
        }
        
        
        
        
        return Reverse(out.next);
        
        
    }
}