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
    //global because objects are also passed as pass by value
    //instead can use TreeNode[] 
    TreeNode prev=null;
        TreeNode first=null;
        TreeNode middle=null;
        TreeNode last=null;

    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && prev.val>root.val){
            if(first!=null) last=root;
            else{
                first=prev;
                middle=root;
            }
        }
        prev=root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {

        inorder(root);
        if(first!=null && last!=null){
           int temp=first.val;
            first.val=last.val;
            last.val=temp;
        }else if(first!=null && middle!=null){
            int temp=first.val;
            first.val=middle.val;
            middle.val=temp;
        }
    }
}