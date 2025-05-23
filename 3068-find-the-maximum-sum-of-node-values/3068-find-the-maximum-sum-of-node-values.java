class Solution {
    //XOR k even no of times on a node: no change
    //      odd number of times: node changes to nums[i] ^ k
    //=> For each node, we have only 2 choices: Keep it as nums[i] or change it to nums[i]^k
    public long maximumValueSum(int[] nums, int k, int[][] edges) {

        ArrayList<Integer> gains=new ArrayList<>(); // to store net gain of each node 
        long basesum=0;
        for(int num : nums) {//o(n)
            gains.add((num^k)-num);
            basesum+=(long)num;
        }
        Collections.sort(gains, Collections.reverseOrder());//o(nlogn)
        for (int i=0; i<gains.size()-1;i+=2){
            long pairSum=gains.get(i)+gains.get(i+1);
            if (pairSum>0) {
                basesum+=pairSum;
            }
        }
        return basesum;
    }
}