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
    public void preorder(TreeNode root,int cnt[]){
        if(root==null) return;
        cnt[0]++;
        preorder(root.left,cnt);
        preorder(root.right,cnt);
    }
    public int countNodes(TreeNode root) {
        int cnt[]={0};
        preorder(root,cnt);
        return cnt[0];
    }
}