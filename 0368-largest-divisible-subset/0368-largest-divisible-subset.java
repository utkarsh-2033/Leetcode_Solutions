class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums); // to ensure checking divisibility by just the previous number ensures divisibility by all number in subset
        int dp[]=new int[n];
        Arrays.fill(dp,1); 
        int hash[]=new int[n];
        for(int i=0;i<n;i++) hash[i]=i;

        for(int i=1;i<n;i++){
            for (int j = 0; j < i; j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
        }
        int ans=-1;
        int lastIndex=-1;
        for(int i=0; i<n; i++){
            if(dp[i]> ans){
            ans = dp[i];
            lastIndex = i;
            }
        }
     
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(nums[lastIndex]);
    
        while(hash[lastIndex] != lastIndex){ 
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);    
        }
        Collections.reverse(temp);

        return temp;
    }
}