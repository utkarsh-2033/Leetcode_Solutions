class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int max=arr[n-1];
        HashSet<Integer> hs=new HashSet<>();
        for(int i:arr) hs.add(i);
        int c=1;
        int ans=1;
        while(c<=k){
            if(!hs.contains(ans)){
                c++;
            }
            ans++;
        }
        return ans-1;
    }
}