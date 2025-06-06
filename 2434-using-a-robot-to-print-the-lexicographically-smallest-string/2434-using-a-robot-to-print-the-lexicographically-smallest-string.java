class Solution {
    public String robotWithString(String s) {
        int n=s.length();
        //storing smallest character from index i to the end
        char min[]=new char[n];
        min[n-1] =s.charAt(n-1);
        for(int i=n-2;i>=0;i--){
            min[i] =(char)Math.min(s.charAt(i),min[i+1]);
        }
        Deque<Character> st =new ArrayDeque<>();
        StringBuilder paper =new StringBuilder();
        int i=0;
        while(i<n){
            st.push(s.charAt(i));
            char minChar=(i+1<n) ? min[i+1] : s.charAt(i);
            while(!st.isEmpty() && st.peek()<=minChar)   paper.append(st.pop());
            i++;
        }
        //remaining characters
        while (!st.isEmpty()) {
            paper.append(st.pop());
        }

        return paper.toString();
    }
}