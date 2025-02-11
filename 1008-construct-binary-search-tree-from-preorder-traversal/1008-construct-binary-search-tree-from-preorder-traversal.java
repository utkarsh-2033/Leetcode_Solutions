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
    public TreeNode construct(int[] pre , int idx[] , int ub){
        if(idx[0]>=pre.length || pre[idx[0]]>ub) return null;
        TreeNode root= new TreeNode(pre[idx[0]++]);
        root.left=construct(pre,idx,root.val); //left upp bound= root.val
        root.right=construct(pre,idx,ub);      // right ub= bound of root
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int idx[]={0};
        return construct(preorder,idx,Integer.MAX_VALUE);
    }
}