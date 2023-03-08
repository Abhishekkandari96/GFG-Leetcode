/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void dfs(TreeNode root, int low, int high, int[] arr){
        if(root==null) return;
        if(root.val>high){
            dfs(root.left,low,high,arr);
        }
        else if(root.val<low){
             dfs(root.right,low,high,arr);
        }
        else{
            arr[0]=arr[0]+root.val;
        
           dfs(root.left,low,high,arr);
              dfs(root.right,low,high,arr);
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        int arr[]={0};
        dfs(root,low,high,arr);
        return arr[0];
    }
}