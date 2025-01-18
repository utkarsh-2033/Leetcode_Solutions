class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int noOfmissing=arr[mid]-(mid+1); // at idx mid- no of missing numbers
            if(noOfmissing<k) low=mid+1;
            else high=mid-1;
        }
        //now range(idx) in which missing number lie- high to low
        int missingNumber=k+high+1;
        return missingNumber;
    }
}