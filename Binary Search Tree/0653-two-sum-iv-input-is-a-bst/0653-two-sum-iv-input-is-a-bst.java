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
class BSTIterator {
    Stack<TreeNode> st;
    boolean reverse;

    public BSTIterator(TreeNode root, boolean reverse) {
        this.st = new Stack<>();
        this.reverse = reverse;
        pushAllLeft(root);
    }

    public int next() {
        TreeNode node = st.pop();
        TreeNode curr = node;
        if (!reverse) {
            if (curr.right != null) {
                curr = curr.right;
                pushAllLeft(curr);
            }
        }else{
            if (curr.left != null) {
                curr = curr.left;
                pushAllLeft(curr);
            }
        }
        return node.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void pushAllLeft(TreeNode node) {
        st.push(node);
        if (!reverse) {
            while (node.left != null) {
                node = node.left;
                st.push(node);
            }
        } else {
            while (node.right != null) {
                node = node.right;
                st.push(node);
            }
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);
        int lval=l.next();
        int rval=r.next();
        while(lval<rval){
            int s=(lval+rval);
            if(s==k) return true;
            else if(s>k) rval=r.next();
            else lval=l.next();
        }
        return false;
    }
}