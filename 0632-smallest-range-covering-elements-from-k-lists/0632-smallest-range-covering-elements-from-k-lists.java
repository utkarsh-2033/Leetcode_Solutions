class tuple{
    int val;int row;int idx;
    tuple(int val,int row,int idx){
         this.val=val;this.row= row;this.idx= idx;
    }
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n=nums.size();
        PriorityQueue<tuple> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        int max=Integer.MIN_VALUE; //to keep track of max value in pq
        for(int i=0;i<n;i++){
            int ele=nums.get(i).get(0);
            pq.offer(new tuple(ele,i,0));
            if(ele>max) max=ele;
        }
        int l=0,r=Integer.MAX_VALUE; // range[l,r]
        while(pq.size()==n){ //row size : ensures 1 ele from each row
            tuple curr=pq.poll();
            if(r-l>max-curr.val){
                l=curr.val;r=max;
            }
            int nxtidx=curr.idx+1;
            if(nxtidx<nums.get(curr.row).size()){
                pq.offer(new tuple(nums.get(curr.row).get(nxtidx),curr.row,nxtidx));
                max=Math.max(max,nums.get(curr.row).get(nxtidx));
            }
        }
        return new int[]{l,r};
    }
}