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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        TreeNode curr=root;
        TreeNode prev=null;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            //if right exist and not been processesd yet(not equal to prev,ie,last processed)
            //move right
            if(st.peek().right!=null && st.peek().right!=prev){
                curr=st.peek().right;
            }else{
                ans.add(st.peek().val);
                prev=st.pop();
            }
        }
        return ans;
    }
}