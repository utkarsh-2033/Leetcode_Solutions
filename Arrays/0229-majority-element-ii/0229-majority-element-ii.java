class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int can1=Integer.MIN_VALUE ,c1=0;
        int can2=Integer.MIN_VALUE ,c2=0;
        for(int i=0;i<nums.length;i++){
            if(c1==0 && can2!=nums[i]){
                c1=1;
                can1=nums[i];
            }
            else if(c2==0 && can1!=nums[i]){
                c2=1;
                can2=nums[i];
            }
            else if(can1==nums[i]) c1++;
            else if(can2==nums[i]) c2++;
            else{
                c1--; c2--;
            }
        }
        int check1=0,check2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==can1) check1++;
            if(nums[i]==can2) check2++;
        }
        List<Integer> ans=new ArrayList<>();
        if(check1>nums.length/3) ans.add(can1);
        if(check2>nums.length/3) ans.add(can2);
        return ans;
    }
}