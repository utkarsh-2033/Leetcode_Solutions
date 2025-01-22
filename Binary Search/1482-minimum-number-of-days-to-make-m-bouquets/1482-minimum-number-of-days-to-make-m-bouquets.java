class Solution {
    public int noOfBouquet(int bloomDay[],int day , int k){
        int bouquets=0,t=0;
        for(int i:bloomDay){
            if(day>=i){
                t++;
            }else{
                bouquets+=t/k;
                t=0;
            }
        }
        bouquets+=t/k;
        return bouquets;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        // imposssible if no. of flowers(n)< m*k(total flower required for m bouquets of k flower each)
        if(n<m*k) return -1;
        //BS on answers
        // range-> min to max of array
        int low=0,high=0,ans=-1;
        for(int i:bloomDay){
            low=Math.min(low,i);
            high=Math.max(high,i);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(noOfBouquet(bloomDay,mid,k)>=m){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        } 
        return ans;
    }
}