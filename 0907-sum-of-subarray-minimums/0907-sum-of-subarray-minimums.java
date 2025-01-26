class Solution {
    public static int mod=1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int nse[]=new int[n]; 
        int pse[]=new int[n];
        Stack<Integer> st=new Stack<>();
        //next greater element array
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]) st.pop();  //montonic increasing stack
            nse[i]=(st.isEmpty())?n:st.peek();
            st.push(i);
        }
        st.clear();
        //previous greater element array
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]) st.pop();  //montonic increasing stack
            pse[i]=(st.isEmpty())?-1:st.peek();
            st.push(i);
        }
        long sum=0;  // to avoid integer overflow
        //summing individual ele contribution
        for(int i=0;i<n;i++){
            sum=(sum+((long)(i-pse[i])*(nse[i]-i)*arr[i])%mod)%mod;
        }
        return (int)sum;
    }
}