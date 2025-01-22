class Solution {
    public int missingNumber(int[] nums) {
        //maths apprach - similar to missing & repaeting problem
        int n=nums.length;
        int Sn=(n*(n+1))/2;
        int S=0;
        for(int num:nums){
            S+=num;
        }
        //Sn-S=missing number
        return (Sn-S);
    }
}