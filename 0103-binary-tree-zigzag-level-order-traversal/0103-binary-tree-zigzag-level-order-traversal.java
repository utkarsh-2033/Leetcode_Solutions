/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        boolean flag=true;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            for(int k=0;k<size;k++){
                TreeNode node=q.poll();
                
                if(flag) level.add(node.val);
                else level.add(0,node.val); // adding at 0 position every time thus reverse order is obtained
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            ans.add(level);
            flag=!flag;
        }
        return ans;
    }
}