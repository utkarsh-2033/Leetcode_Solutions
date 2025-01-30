class StockSpanner {
    // pge - decreasing monotonic stack
    Stack<int[]> st;    // 0:index ,1:price
    int index;          // manual index
    public StockSpanner() {
        st=new Stack<>();
        index=0;
    }
    
    public int next(int price) {
        
        while(!st.isEmpty() && price>=st.peek()[1]) st.pop();
        int span=(st.isEmpty())?index+1:index-st.peek()[0];
        st.push(new int[]{index,price});
        index++;
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */