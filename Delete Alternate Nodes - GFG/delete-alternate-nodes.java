//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    	

    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    
		    Node head1 = null,tail1 = null;
		    
		    int n1 = sc.nextInt();
            int d1 = sc.nextInt();		    
		    head1 = new Node(d1);
		    tail1 = head1;
		    
		    while(n1-- > 1){
		        tail1.next = new Node(sc.nextInt());
		        tail1 = tail1.next;
		    }
		    
		    Solution obj = new Solution();
		    obj.deleteAlternate(head1);
		    while(head1 != null){
		        System.out.print(head1.data + " ");
		        head1 = head1.next;
		    }
		    System.out.println();
		}
	}

}


// } Driver Code Ends


/*
class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    
   
    // public void print(Node head){
    //     while(head!=null){
    //         System.out.print(head.data+" ");
    //         head=head.next;
    //     }
    // }
    public void deleteAlternate (Node head){
        //Write your code here
        Node temp=head;
        Node s1=temp;
        while(s1!=null && s1.next!=null){
            s1.next=s1.next.next;
            // Node help=s1.next;
            // s1.next=null;
            // s1.next=help.next;
            // s1=s1.next;
            s1=s1.next;
            
            }
           
           //print(temp);
        }
    
}