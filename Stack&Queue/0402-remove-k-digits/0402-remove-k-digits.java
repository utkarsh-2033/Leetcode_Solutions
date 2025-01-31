class Solution {
    public String removeKdigits(String num, int k) {
    Stack<Character> st= new Stack<>(); 
        for(int i=0;i<num.length();i++){
         char ch=num.charAt(i);
            while(!st.isEmpty() && st.peek()>ch && k-->0) st.pop();
            st.push(ch);
        }
        while(k>0 && !st.isEmpty()){
            st.pop();k--;
            }
        String ans="";
        while(!st.isEmpty()) ans=st.pop()+ans;
        
        int i;
        for( i=0;i<ans.length();i++){
            if(ans.charAt(i)!='0') break;
        }
        ans=ans.substring(i,ans.length());
        if(ans.length()==0) return "0";
        return ans;
    }
} 