class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)  return new int[0][0];
        Arrays.sort(intervals,Comparator.comparingInt(a -> a[0]));
        ArrayList<List<Integer>> temp=new ArrayList<>();
        int st=intervals[0][0];
        int end=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end)
                end=Math.max(end,intervals[i][1]);
            else {
                temp.add(Arrays.asList(st,end));
                st=intervals[i][0];
                end=intervals[i][1];
            }
        }
        temp.add(Arrays.asList(st, end)); //last interval
        int[][] ans = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            ans[i][0] = temp.get(i).get(0);
            ans[i][1] = temp.get(i).get(1);
        }

        return ans;
    }
}