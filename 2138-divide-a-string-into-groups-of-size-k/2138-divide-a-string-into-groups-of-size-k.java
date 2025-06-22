class Solution {
    public String[] divideString(String s, int k, char fill){
        int n=(int)Math.ceil((1.0)*s.length()/k);
        String[] ans=new String[n];
        if(s.length()<k){
            ans[0]=s;
            return ans;
        } 
        int i;
        int m=0;
        for(i=0;i<s.length();i=i+k){
           if(i+k<=s.length()) ans[m++]=s.substring(i,i+k);
             else {
                String l = s.substring(i);
                int p = k - l.length();
                while(p-- > 0) l += fill;
                ans[m++] = l;
            }
        }
        return ans;
    }
}