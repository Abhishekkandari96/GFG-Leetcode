//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


class Merge_2_sorted_ll_In_ReverseOrder
{
    Node head;

    void addToTheLast(Node node)
    {
        if(head == null)
            head = node;
        else
        {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    void printList(Node node)
    {
        while(node!= null)
        {
            System.out.print(node.data+ " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String args[]) throws IOException
    {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0)
        {
            String nums[] = br.readLine().split(" ");
            int n1 = Integer.parseInt(nums[0]);
            int n2 = Integer.parseInt(nums[1]);
            Merge_2_sorted_ll_In_ReverseOrder list = new Merge_2_sorted_ll_In_ReverseOrder();
            nums = br.readLine().split(" ");
            int a1 = Integer.parseInt(nums[0]);
            Node head = new Node(a1);
            list.addToTheLast(head);
            for(int i=1;i<n1;i++)
            {
                int a = Integer.parseInt(nums[i]);
                list.addToTheLast(new Node(a));
            }
            //list.printList(list.head);

            Merge_2_sorted_ll_In_ReverseOrder list2 = new Merge_2_sorted_ll_In_ReverseOrder();
            nums = br.readLine().split(" ");
            int b1 = Integer.parseInt(nums[0]);
            Node head1 = new Node(b1);
            list2.addToTheLast(new Node(b1));
            for(int j=1;j<n2;j++)
            {
                int b = Integer.parseInt(nums[j]);
                list2.addToTheLast(new Node(b));				
            }
            //list.printList(list2.head);
            
            GfG g = new GfG();
            Node result = g.mergeResult(list.head, list2.head);
            list.printList(result);
            t--;
        }
    }
}
// } Driver Code Ends


/* Structure of the node*/
/* class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
} */

class GfG
{
    Node merge(Node head1,Node head2){
        
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(head1!=null&& head2!=null){
            if(head1.data>head2.data){
                Node help=head1.next;
                head1.next=null;
                temp.next=head1;
                head1=help;
                temp=temp.next;
                
                
            }
            else{
                Node help=head2.next;
                head2.next=null;
                temp.next=head2;
                head2=help;
                temp=temp.next;
            }
        }
        if(head2!=null){
            temp.next=head2;
        }
        if(head1!=null){
            temp.next=head1;
        }
        return dummy.next;
        
    }
    Node reverse(Node head){
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
    Node mergeResult(Node head1, Node head2)
    {
	// Your code here
	head1=reverse(head1);
	head2=reverse(head2);
	
	//merge
	return merge(head1,head2);
	
	
	
    }
}
