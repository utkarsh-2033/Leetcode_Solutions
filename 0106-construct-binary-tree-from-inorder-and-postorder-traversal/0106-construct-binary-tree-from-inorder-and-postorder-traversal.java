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
    //inorder- to get left and right subtree L N R
    //inorder range- left to right
    //postorder- to get root -L R N
    public TreeNode constructTree(int[] inorder , Map<Integer,Integer> mp,
    int[] postorder,int postidx[],int left,int right){
        if(left > right) return null;
        int rootval=postorder[postidx[0]];
        TreeNode root=new TreeNode(rootval);
        postidx[0]--;
        int inorderidx=mp.get(rootval);
        root.right=constructTree(inorder,mp,postorder,postidx,inorderidx+1,right);
        root.left=constructTree(inorder,mp,postorder,postidx,left,inorderidx-1);
        return root;
    } 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> mp =new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i); // for 0(1) lookup of root in inorder to get left and right subtree
        }
        int postidx[]={postorder.length-1}; 
        TreeNode root=constructTree(inorder,mp,postorder,postidx,0,inorder.length-1);
        return root;
    }
}