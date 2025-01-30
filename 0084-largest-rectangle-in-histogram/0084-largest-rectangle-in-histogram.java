class Solution {
    public int largestRectangleArea(int[] heights) {
        //pse & nse
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=heights.length;i++){
            while(!st.isEmpty() && (i==heights.length || heights[i]<heights[st.peek()])){
                int height=heights[st.pop()];
                int width=(st.isEmpty())?i:(i-st.peek()-1);
                maxArea=Math.max(maxArea,height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
}