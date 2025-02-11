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
    public TreeNode constructTree(int[] preorder,int[] inorder,Map<Integer,Integer> mp,
    int preidx[],int left , int right){
        if(left>right) return null;
        int rootval=preorder[preidx[0]];
        TreeNode root=new TreeNode(rootval);
        preidx[0]++;
        int inorderidx=mp.get(rootval);
        root.left=constructTree(preorder,inorder,mp,preidx,left,inorderidx-1);
        root.right=constructTree(preorder,inorder,mp,preidx,inorderidx+1,right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> mp=new HashMap<>();
        int preidx[]={0};
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return constructTree(preorder,inorder,mp,preidx,0,inorder.length-1);
    }
}