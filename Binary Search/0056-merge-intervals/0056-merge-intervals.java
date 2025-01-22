class Solution {
    public int[][] merge(int[][] intervals) {
        // sorting based on starting value of intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> ans = new ArrayList<>();
        
        for (int interval[] : intervals) {
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
        }
        // int result[][] = new int[ans.size()][2];
        // for (int i = 0; i < ans.size(); i++) {
        //     result[i] = ans.get(i);
        // }
        // return result;
        return ans.toArray(new int[ans.size()][]);
    }
}