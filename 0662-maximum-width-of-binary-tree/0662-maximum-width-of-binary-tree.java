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
    class pair{
        TreeNode node;int idx;
        pair(TreeNode node,int idx){
            this.node=node;this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q=new LinkedList<>();
        int max=0;
        q.offer(new pair(root,0));  //0-based indexing
        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().idx; //starting idx of each level
            int start=0;int last=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.peek().node;
                int idx=q.peek().idx -min ; //to prevent int overfloe for very large skewed trees
                q.poll();
                if(i==0) start=idx;
                if(i==size-1) last=idx;
                if(node.left!=null) q.offer(new pair(node.left,2*idx+1));
                if(node.right!=null) q.offer(new pair(node.right,2*idx+2));
            }
            max=Math.max(max,last-start+1);
        }
        return max;
    }
}