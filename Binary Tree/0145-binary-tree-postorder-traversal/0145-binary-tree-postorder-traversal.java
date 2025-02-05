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
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> st=new Stack<>();
        Stack<Integer> ans=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            ans.push(node.val);
            if(node.left!=null) st.push(node.left);
            if(node.right!=null) st.push(node.right);
        }
        while(!ans.isEmpty()){
            res.add(ans.pop());
        }
        return res;
    }
}