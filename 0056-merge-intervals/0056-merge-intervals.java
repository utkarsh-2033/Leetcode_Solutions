class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        ArrayList<int[]> a=new ArrayList<>();
        a.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int len=a.size();
            if(a.get(len-1)[1]>=intervals[i][0]){
                int s=Math.min(a.get(len-1)[0],intervals[i][0]);
                int l=Math.max(a.get(len-1)[1],intervals[i][1]);
                a.remove(len-1);
                a.add(new int[]{s,l});
            }else{
                a.add(intervals[i]);
            }
        }
        int ans[][]=new int[a.size()][2];
        for(int i=0;i<a.size();i++) ans[i]=a.get(i);
        return ans;
    }
}