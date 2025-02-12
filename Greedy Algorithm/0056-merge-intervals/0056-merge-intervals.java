class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        ArrayList<int[]> ans =new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int n=ans.size();
            if(ans.get(n-1)[1]>=intervals[i][0]){
                ans.get(n-1)[1]=Math.max(ans.get(n-1)[1],intervals[i][1]);
            }
            else ans.add(intervals[i]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}