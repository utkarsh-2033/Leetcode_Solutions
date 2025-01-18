class Solution {
    // int max(int[] arr){
    //     int mx=Integer.MIN_VALUE;
        // for(int i=0;i<arr.length;i++){
        //     mx=Math.max(mx,arr[i]);
        // }
    //     return mx;
    // }
    // int min(int[] arr){
    //     int min=Integer.MAX_VALUE;
    //     for(int i=0;i<arr.length;i++){
    //         min=Math.min(min,arr[i]);
    //     }
    //     return min;
    // }
    int NoOfBq(int day,int[] bloomDay,int k){
        int c=0,n=0;
        for(int i=0;i<bloomDay.length;i++){
            if(day>=bloomDay[i]) c++;
            else {
                n+=c/k;
                c=0;
            }
        } n+=c/k;
        return n;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int mx=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            mx=Math.max(mx,bloomDay[i]);
            min=Math.min(min,bloomDay[i]);
        }
        if(m*k>bloomDay.length) return -1;
        int low=min,high=mx,mid,ans=-1;
        while(low<=high){
            mid=low+(high-low)/2;
            if(NoOfBq(mid,bloomDay,k)>=m) {
                ans=mid;high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}