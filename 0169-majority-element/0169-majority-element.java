class Solution {
    public int majorityElement(int[] nums) {
        int c=0,can=-1;
        for(int i=0;i<nums.length;i++){
            if(c==0){
                can=nums[i];
            }
            if(nums[i]==can) c++;
            else c--;
        }
        return can;
    }
}