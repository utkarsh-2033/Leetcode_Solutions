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
    public boolean isValid(TreeNode root , long min , long max){
        if(root==null) return true;
        // "=" for cases if duplicates presenet,[2 2 2]- should be false bcoz BST cant contain duplicates
        if(root.val<=min || root.val>=max ) return false; // not in range
        if(!isValid(root.left,min,root.val)) return false;
        if(!isValid(root.right,root.val,max)) return false;
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        //Long for avoiding int overflow i case root.val= int-min or max
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}