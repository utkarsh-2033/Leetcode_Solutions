class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long s1=0,s2=0;
        int n1=0,n2=0;
        for (int i: nums1) {
            s1+=i;
            if(i==0) n1++;
        }
        for (int i: nums2) {
            s2+=i;
            if(i==0) n2++;
        }
        long mins1= s1+n1; //minimum sun of array 1 - after replacing all 0 wid 1
        long mins2= s2+n2;
        if (mins1==mins2) {
            return mins1;
        }
        //mins1 is smaller so it can be increased to make mins2 
        //by just dumping the extra neede on any 1(initially 0)
        //if only if num1 arr has atleast one 1(initially 0) else not possible(return -1)
        if (mins1<mins2) { 
            return (n1>0?mins2:-1);
        } else {
            return (n2>0?mins1:-1);
        }
    }
}
