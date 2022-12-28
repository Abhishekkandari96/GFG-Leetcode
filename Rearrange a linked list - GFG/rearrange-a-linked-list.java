//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            new Solution().rearrangeEvenOdd(head);
            printList(head); 
            t--;
        }
    } 
} 

// } Driver Code Ends


/*

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
This is method only submission.
You only need to complete the below method.
*/
class Solution
{

   // Should rearrange given linked list such that all even
   // positioned Nodes are before odd positioned.
   // Returns nothing
//   void print(Node head){
//       Node temp=head;
//       while(temp!=null){
//           System.out.print(temp.data+" ");
//           temp=temp.next;
//       }
//   }
    void rearrangeEvenOdd(Node head)
    {
          //  The task is to complete this method
          
          Node even=head;
          Node c1=even;
          Node odd=head.next;
          Node c2=odd;
          while(c2!=null && c2.next!=null){
              
              c1.next=null;
              c1.next=c2.next;
              c1=c1.next;
              
              c2.next=null;
              c2.next=c1.next;
              c2=c2.next;
          }
          c1.next=null;
          c1.next=odd;
          
          
     }
}
