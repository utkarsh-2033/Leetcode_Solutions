class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        //1.subaarays minimum array-nse & pse
        int nse[]=new int[n]; //nse
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]<=nums[st.peek()]) st.pop();
            nse[i]=(st.isEmpty())? n:st.peek();
            st.push(i);
        }
        st.clear();
        long sumMin=0;
        int pse[]=new int[n]; //nse
        //pse+ sum
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i]<nums[st.peek()]) st.pop();
            pse[i]=(st.isEmpty())? -1:st.peek();
            st.push(i);

            sumMin+=(long)(nse[i]-i)*(i-pse[i])*nums[i];
        }
        st.clear();
        //1.subaarays maximum array-nge & pge
        int nge[]=new int[n]; //nge
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>=nums[st.peek()]) st.pop();
            nge[i]=(st.isEmpty())? n:st.peek();
            st.push(i);
        }
        st.clear();
        long sumMax=0;
        int pge[]=new int[n]; 
        //pge+ sum
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]) st.pop();
            pge[i]=(st.isEmpty())? -1:st.peek();
            st.push(i);

            sumMax+=(long)(nge[i]-i)*(i-pge[i])*nums[i];
        }
        return sumMax-sumMin;
    }
}