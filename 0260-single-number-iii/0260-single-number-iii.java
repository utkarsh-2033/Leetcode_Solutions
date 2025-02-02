class Solution {
    public int[] singleNumber(int[] nums) {
        //xor of 2 required no.s
        int xor=0;
        for(int i: nums) xor^=i;
        //two distinct no.s have atleas 1 bit diff
        //finding the rightmost diff bit bw the two required no.s
        //          == righmost set bit in xor of the 2 nos
        int i=0;
        for(i=0;i<31;i++){
            if((xor&(1<<i))!=0) break;
        }
        //buceting based on the ith bit-to ensure the 2 reuired no lie on diff buckets
        int b1=0;int b2=0;
        for(int num:nums){
            if((num&(1<<i))==0) b1^=num;
            else b2^=num;
        }
        return new int[]{b1,b2};
    }
}