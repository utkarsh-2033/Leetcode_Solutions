
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        boolean nullseen=false;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            if(current.left!=null){
                if(nullseen) return false;
                q.add(current.left);
            }else nullseen=true;
            if(current.right!=null){
                if(nullseen) return false;
                q.add(current.right);
            }else nullseen=true;
        }
        return true;
    }
}