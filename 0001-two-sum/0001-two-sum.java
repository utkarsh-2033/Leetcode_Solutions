class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hs.containsKey(target-nums[i])) return new int[]{i,hs.get(target-nums[i])};
            else hs.put(nums[i],i);
        }
        return new int[]{};
    }
}