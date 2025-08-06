class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int[] st = new int[4*n];
        build(0, 0, n-1,baskets, st);
        int unplaced = 0;
        for (int fruit : fruits) {
            if (!querySegmentTree(0,0,n-1, st,fruit)) {
                unplaced++;
            }
        }
        return unplaced;
    }
    private void build(int i,int l,int r,int[] baskets, int[] st){
        if (l == r){
            st[i] =baskets[l];
            return;
        }
        int m = (l + r) / 2;
        build(2*i+1,l,m,baskets,st);
        build(2*i+2,m+1,r,baskets,st);
        st[i]=Math.max(st[2*i+1],st[2*i+2]);
    }

    private boolean querySegmentTree(int i, int l, int r, int[] st, int val) {
        if(st[i]<val){
            return false; // No basket
        }
        if(l == r){
            st[i] =-1; // used - marking
            return true;
        }
        int mid =(l+r)/2;
        boolean placed;
        if(st[2 * i + 1] >= val){
            placed = querySegmentTree(2*i+1,l,mid,st,val);
        }else{
            placed =querySegmentTree(2*i+2,mid+1,r,st,val);
        }
        st[i] =Math.max(st[2*i+1],st[2*i+2]);
        return placed;
    }
}