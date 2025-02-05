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
    public int height(TreeNode root){
        if(root==null) return 0;
        int l=height(root.left);
        if(l==-1) return -1;    // -1 means we are backtracking with already -1 received at a node(unbalanced) 
        // so return -1 and backtrack from here no need to right
        int r=height(root.right);
        if(r==-1) return -1;
        if(Math.abs(l-r)>1) return -1; // if not balanced return -1 and backtrack from here itself
        return 1+(Math.max(l,r));
    }
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }
}