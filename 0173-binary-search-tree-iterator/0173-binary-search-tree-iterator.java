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
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st=new Stack<>();
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode node=st.pop();
        TreeNode curr=node;
        if(curr.right!=null){
            curr=curr.right;
            pushAllLeft(curr);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    public void pushAllLeft(TreeNode node){
        st.push(node);
        while(node.left!=null){ 
            node=node.left;
            st.push(node);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */