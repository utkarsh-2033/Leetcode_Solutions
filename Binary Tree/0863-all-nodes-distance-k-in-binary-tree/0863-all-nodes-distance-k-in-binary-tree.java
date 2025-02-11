/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //parents node marking by bfs
    public void parentsMarking(HashMap<TreeNode,TreeNode> mp,TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null){
                    mp.put(node.left,node);
                    q.offer(node.left);
                }
                if(node.right!=null){
                    mp.put(node.right,node);
                    q.offer(node.right);
                }
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> mp = new HashMap<>();
        parentsMarking(mp, root);
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.add(target);
        int dist = 0;
        while (!q.isEmpty()) {  //bfs
            if (k == dist) break;   
            int size = q.size();
            dist++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll(); // 3 directions to explore from each node
                if (node.left != null && !visited.contains(node.left)) { //going left
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {//going right
                    q.offer(node.right);
                    visited.add(node.right);
                }
                if (mp.containsKey(node) && !visited.contains(mp.get(node))) {//going up
                    q.offer(mp.get(node));
                    visited.add(mp.get(node));
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}