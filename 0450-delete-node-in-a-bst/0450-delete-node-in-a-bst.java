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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        TreeNode curr = root;
        TreeNode parent = null;
        while (curr != null) {
            if (curr.val > key) {
                parent = curr;
                curr = curr.left;
            } else if (curr.val < key) {
                parent = curr;
                curr = curr.right;
            }
            // node found-to be deleted (curr=key)
            else {
                // both child or 1 child null(of the node to be deleted)
                if (curr.right == null || curr.left == null) {
                    TreeNode child = (curr.right == null) ? curr.left : curr.right;
                    if (parent == null)
                        return child; // deleting root
                    if (curr == parent.left)
                        parent.left = child;
                    else
                        parent.right = child;
                }
                // both child exists
                else {
                    // right tree exists since both child exist
                    TreeNode successor = curr.right;
                    TreeNode successorParent = curr;
                    while (successor.left != null) {
                        successorParent = successor;
                        successor = successor.left;
                    }
                    // replacing curr(to be deleted) with inorder successor and
                    // then deleting successor by proper changing links
                    curr.val = successor.val;
                    if (successorParent.left == successor)
                        successorParent.left = successor.right;
                    else
                        successorParent.right = successor.right; // incase still successorparent=curr
                }
                    return root; //**** deleted so terminate from loop
            }
        }
        return root;
    }
}