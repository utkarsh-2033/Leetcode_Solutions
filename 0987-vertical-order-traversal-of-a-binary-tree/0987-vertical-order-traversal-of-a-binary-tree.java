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
    class tuple{
        TreeNode node;
        int col;
        int level;
        tuple(TreeNode node,int col,int level){
            this.node=node;this.col=col;this.level=level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp=new TreeMap<>();
        Queue<tuple> q=new LinkedList<>(); // bfs
        q.offer(new tuple(root,0,0)); // root at 0,0
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.peek().node;
                int col=q.peek().col;
                int level=q.peek().level;
                q.poll();
                mp.putIfAbsent(col,new TreeMap<>());
                mp.get(col).putIfAbsent(level,new PriorityQueue<>());
                mp.get(col).get(level).offer(node.val);
                if(node.left!=null){
                    q.offer(new tuple(node.left,col-1,level+1));
                }
                if(node.right!=null){
                    q.offer(new tuple(node.right,col+1,level+1));
                }
            }
        }
        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> entry:mp.entrySet()){
            List<Integer> colList = new ArrayList<>();
            for(Map.Entry<Integer,PriorityQueue<Integer>> e:entry.getValue().entrySet()){
                colList.addAll(new ArrayList<>(e.getValue()));
            }
            ans.add(colList);
        }
        return ans;
    }
}