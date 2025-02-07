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
    //search in bst
    //keeping a prev pointer and a flag to check left or right 
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode curr=root;
        int f=0;
        TreeNode prev=null;
        while(curr!=null){
            if(curr.val>val){
                prev=curr; f=0;
                curr=curr.left;
            }else{
                prev=curr;f=1;
                curr=curr.right;
            }
        }
        if(f==0) prev.left=new TreeNode(val);
        else prev.right=new TreeNode(val);
        return root;
    }
}