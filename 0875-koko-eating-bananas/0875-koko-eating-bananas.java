class Solution {
    //to calculate hours taken to eat all bananas with "k" banana per hour
    public int totalHours(int k , int piles[]){
        int t=0;
        for(int pile:piles){
            t+=Math.ceil((double)pile/(double)k);
        }
        return t;
    }
    public int minEatingSpeed(int[] piles, int h) {
        //BS on answers
        //range 1 to max of array
        int low=1,high=-1;
        for(int i:piles) high=Math.max(high,i);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(totalHours(mid,piles)<=h) high=mid-1; // minimum possible speed/int k
            else low=mid+1;
        }
        return low; // opposite polarity
    }
}