class Solution {
    public int trap(int[] height) {
        //two pointer aprroach 
        int lmax=Integer.MIN_VALUE;
        int rmax=Integer.MIN_VALUE;
        int l=0,r=height.length-1;
        int totalwater=0;
        while(l<=r){
            if(height[l]<=height[r]){
                lmax=Math.max(lmax,height[l]);
                totalwater+=(lmax-height[l]);
                l++;
            }else{
                rmax=Math.max(rmax,height[r]);
                totalwater+=(rmax-height[r]);
                r--;
            }
        }
        return totalwater;
    }
}