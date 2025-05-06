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
        Stack<TreeNode> s=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        st.add(root);
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            s.add(node);
            if(node.left!=null) st.add(node.left);
            if(node.right!=null) st.add(node.right);
        }
        while(!s.isEmpty()) ans.add(s.pop().val);
        return ans;
    }
}