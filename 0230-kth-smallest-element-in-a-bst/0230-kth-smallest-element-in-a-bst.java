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
    public void helper(TreeNode root,int cnt[],int k,int ans[]){
        if(root==null) return ;
        helper(root.left,cnt,k,ans);
        cnt[0]++;
        if(cnt[0]==k) {
            ans[0]=root.val;
            return;
        }
        helper(root.right,cnt,k,ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        int cnt[]={0};
        int ans[]={-1};
        helper(root,cnt,k,ans);
        return ans[0];
    }
}