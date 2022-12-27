//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    System.out.println(obj.sum(head, k));
		}
	}
}
// } Driver Code Ends


/*
Node class is as follows:

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
    //Return the sum of last k nodes
    public Node  Reverse(Node head){
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
    public int sum(Node head, int k){
      //write code here
        Node rev= Reverse(head);
      Node temp=rev;
      int i=1;
      
      int sum=0;
      while(i<=k){
          sum=sum+temp.data;
          temp=temp.next;
          i++;
      }
      return sum;
    }
}