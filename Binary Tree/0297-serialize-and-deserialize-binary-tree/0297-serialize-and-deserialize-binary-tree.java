/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder s=new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null) s.append("N,");
            else{
                s.append(node.val).append(",");
                q.offer(node.right);
                q.offer(node.left);
            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String arr[]=data.split(",");
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int idx=1;
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(!arr[idx].equals("N")){
                TreeNode right=new TreeNode(Integer.parseInt(arr[idx]));
                node.right=right;
                q.offer(right);
            }idx++;
            if(!arr[idx].equals("N")){
                TreeNode left=new TreeNode(Integer.parseInt(arr[idx]));
                node.left=left;
                q.offer(left);
            }idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));