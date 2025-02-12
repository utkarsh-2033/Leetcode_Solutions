class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans=new ArrayList<>();
        //already sorted in ascending accord to start
        int n=intervals.length;
        int i=0;
        while(i<n && intervals[i][1]< newInterval[0]) {
            ans.add(intervals[i]); i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while(i<n){ ans.add(intervals[i]); i++; }

        // int[][] res= new int[ans.size()][2];
        // for(int j=0;i<res.length;j++){
        //     res[j]=ans.get(j);
        // }
        // return res;
        return ans.toArray(new int[ans.size()][]);
    }
    
}