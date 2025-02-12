class Solution {
    //similar to - N meetings in one room problem
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]); //sorting based on end
        int count=1; // counting which will be in the array after removing overlappings
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){ // starting from 1 since 1st already included(intial count=1)
            if(intervals[i][0]>=end){ //if start[i]=end[i+1]- not considered overlapping
                count++;
                end=intervals[i][1];
            }
        }
        return intervals.length-count;
    }
}