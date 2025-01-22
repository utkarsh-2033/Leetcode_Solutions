class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //BS on smaller array
        int n1=nums1.length;
        int n2=nums2.length;
        int n=n1+n2;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1); //if 2nd array is smaller
        //considering 1st array is smaller
        int low=0,high=n1;
        while(low<=high){
            int mid1=low+(high-low)/2;
            int mid2=(n+1)/2-mid1;
            int left1=(mid1>0)? nums1[mid1-1]:Integer.MIN_VALUE;
            int right1=(mid1==n1)? Integer.MAX_VALUE:nums1[mid1];
            int left2=(mid2>0)? nums2[mid2-1]:Integer.MIN_VALUE;
            int right2=(mid2==n2)? Integer.MAX_VALUE:nums2[mid2];
            if(left1<=right2 && left2<=right1){
                if(n%2==0){ //even
                   return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                }else{
                    return Math.max(left1,left2)/1.0;
                }
            }
            else if(left2>right1) low=mid1+1; 
            else high=mid1-1;

        }
        return 0.0;
    }
}