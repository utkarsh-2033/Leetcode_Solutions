class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0; // pointer for g(greed)-children
        int j=0; //pointer for s(size)-cookies
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]) i++;   //moving to next child only if greed satisfied
            j++; //moving to next cookie every time
        }
        return i;
    }
}