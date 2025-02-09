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
    public TreeNode construct(int preorder[], int inorder[],int preidx[], 
    Map<Integer,Integer> mp ,int left,int right ){
        if(left>right) return null;
        int rootval=preorder[preidx[0]];
        TreeNode root=new TreeNode(rootval);
        preidx[0]++;
        int inorderidx=mp.get(rootval);
        root.left=construct(preorder,inorder,preidx,mp,left,inorderidx-1);
        root.right=construct(preorder,inorder,preidx,mp,inorderidx+1,right);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        //using property that inorder of bst is sorted
        // then using general concept of creating tree from preorder and inorder
        int []inorder=preorder.clone();
        Arrays.sort(inorder);
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        int preidx[]={0};
        TreeNode root=construct(preorder,inorder,preidx,mp,0,inorder.length-1);
        return root;
    }
}