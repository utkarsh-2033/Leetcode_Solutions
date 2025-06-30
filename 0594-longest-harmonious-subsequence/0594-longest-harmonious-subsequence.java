class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i:nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        int ans=0;
        //subequence can only contain 2 ele- min and max & max=min+1
        //considering every ele as min and finding max possible length 
        for(int i:nums){
            int len=0;
            if(mp.containsKey(i+1)) len+=mp.get(i+1)+ mp.get(i);
            ans=Math.max(len,ans);
        }
        return ans;
    }
}