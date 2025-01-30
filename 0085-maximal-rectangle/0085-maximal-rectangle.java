class Solution {
    public int MaxArea(int arr[],int n){
        Stack<Integer> st=new Stack<>();
        int mx=0;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || arr[i]<arr[st.peek()])){
                int h=arr[st.pop()];
                int w=(st.isEmpty())? i:(i-st.peek()-1);
                mx=Math.max(mx,h*w);
            }
            st.push(i);
        }
        return mx;
    }
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int ps[][]=new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=matrix[i][j]-'0';
                if(matrix[i][j]=='0') sum=0;
                ps[i][j]=sum;
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,MaxArea(ps[i],m));
        }
        return max;
    }
}