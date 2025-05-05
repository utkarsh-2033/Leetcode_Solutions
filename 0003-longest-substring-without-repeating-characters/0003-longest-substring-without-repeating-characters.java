class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0,r=0;
        int mx=0;
        Set<Character> st=new HashSet<>();
        while(r<n){
            while(st.contains(s.charAt(r))){
                st.remove(s.charAt(l));
                l++;
            }
            if(!st.contains(s.charAt(r))){
                st.add(s.charAt(r));
                mx=Math.max(mx,r-l+1);
                r++;
            }
        }
        return mx;
    }
}