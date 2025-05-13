class Solution {
    int M=(int)1e9+7;
    public int lengthAfterTransformations(String s, int t) {
        // HashMap<Character,Integer> mp=new HashMap<>();
        int mp[]=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            mp[ch-97]++;
        }
        // HashMap<Character,Integer> temp;
        int temp[];
        for(int i=1;i<=t;i++){
            temp=new int[26];
            for(char ch='a';ch<='z';ch++){
                char nxt=(char)(ch+1);
                if(ch=='z'){
                    temp['a'-97]=(mp[ch-97]+temp['a'-97])%M;
                    temp['b'-97]=(mp[ch-97]+temp['b'-97])%M;
                }else{
                    temp[nxt-97]=(mp[ch-97]+temp[nxt-97])%M;
                }
            }
            mp=temp;
        }
        int len=0;
        for(int i:mp) len=(len+i)%M;
        return len;
    }
}