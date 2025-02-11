class Solution {
    public int jump(int[] nums) {
        int jumps=0; //count of jumps
        int maxReach=0; // track of farthest posn that can be reached from that index
        int end=0; //tracking jump boundary (when we must jump).
        for(int i=0;i<nums.length-1;i++){ //n-1 : no need to make jump from the last idx , since already reached last idx(destination)
            maxReach=Math.max(maxReach,i+nums[i]);
            if(i==end){ //jumping only when forced to(reached end of current boundary)
                jumps=jumps+1; 
                end=maxReach; //setting next boundary to the current 
                              //idx maxReach(farthest that can be reached from that index)
            }
        }
        return jumps;
    }
}