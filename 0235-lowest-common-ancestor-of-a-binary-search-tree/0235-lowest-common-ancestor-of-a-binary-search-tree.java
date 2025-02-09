/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr=root;
        while(curr!=null){
            //if both smaller than root => both lies left
            if(p.val<curr.val && q.val<curr.val) curr=curr.left;
            //if both greater than root => both lies right
            else if(p.val>curr.val && q.val>curr.val) curr=curr.right;
            //diveging point is the LCA
            else return curr;
        }
        return null;
    }
}