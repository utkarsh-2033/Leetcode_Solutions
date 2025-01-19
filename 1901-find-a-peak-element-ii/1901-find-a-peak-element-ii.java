class Solution {
    public int[] findPeakGrid(int[][] mat) {
        //BS- range - row 
        int low=0,high=mat[0].length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            //to find max of col[mid]
            int max=Integer.MIN_VALUE;
            int idx=-1;
            for(int i=0;i<mat.length;i++){
                if(max<mat[i][mid]){
                    max=mat[i][mid];
                    idx=i;
                }
            }
            int left=(mid!=0)?mat[idx][mid-1]:-1;
            int right=(mid!=mat[0].length-1)?mat[idx][mid+1]:-1;
            if(mat[idx][mid]>right && mat[idx][mid]>left){
                return new int[]{idx,mid};
            }else if(mat[idx][mid]<right) low=mid+1;
            else high=mid-1;

        }
        return new int[]{-1,-1};
    }
}