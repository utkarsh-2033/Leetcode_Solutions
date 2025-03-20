class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int arr[]=new int[n];
        //considering left neighbours
        arr[0]=1; // since posn 0 have no left neighbour so giving greedily minimum =1
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                arr[i]=arr[i-1]+1;
            }
            else arr[i]=1;
        }
        // considering right neighbours 
        //and submerging the left and calculating sum in same pass 
        int total=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                arr[i]=Math.max(arr[i],arr[i+1]+1);
            }
            else arr[i]=Math.max(1,arr[i]);
            total+=arr[i];
        } 
        return total;
    }
}