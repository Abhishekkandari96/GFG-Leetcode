//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node head, int x) {
        // Your code here
        Node less=new Node (0);
        Node more =new Node (0);
        Node equal=new Node(0);
        Node et=equal;
        Node lt=less;
        Node mt=more;
        Node temp=head;
        while(temp!=null){
            Node nextv=temp.next;
            if(temp.data<x){
                temp.next=null;
                lt.next=temp;
                lt=lt.next;
                temp=nextv;
            }
            else if(temp.data>x){
                temp.next=null;
                mt.next=temp;
                mt=mt.next;
                temp=nextv;
            }
            else{
                temp.next=null;
                et.next=temp;
                et=et.next;
                temp=nextv;
                
            }
        }
        if(equal.next==null){
             lt.next=more.next;
           // et.next=more.next;
            mt.next=null;
        }
        else{
            lt.next=equal.next;
            et.next=more.next;
            mt.next=null;
        }
            
          
            return less.next;
    }
}