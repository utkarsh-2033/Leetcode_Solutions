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
    public int pathSum(TreeNode root,int mx[]){
        if(root==null) return 0;
        int l=Math.max(0,pathSum(root.left,mx));  //to ignore -ve sum(since max finding)
        int r=Math.max(0,pathSum(root.right,mx));
        mx[0]=Math.max(mx[0],l+r+root.val);
        return root.val+Math.max(l,r);
    }
    public int maxPathSum(TreeNode root) {
        int mx[]={Integer.MIN_VALUE};
        pathSum(root,mx);
        return mx[0];
    }
}