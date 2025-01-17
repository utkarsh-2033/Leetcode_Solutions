class Solution {
    public int countdays(int weights[],int capacity){
        int s=0;
        int days=0;
        for(int weight:weights){
            s+=weight;
            if(s>capacity){
                days++;
                s=weight;
            }
        }
        return days+1;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=0, high=0,ans=0;
        for(int weight:weights){
            high+=weight;
            low=Math.max(low,weight);
        } 
        while(low<=high){
            int mid=low+(high-low)/2;
            if(countdays(weights,mid)<=days){ ans=mid;high=mid-1;}
            else low=mid+1;
        }
        return ans;   
    }
}