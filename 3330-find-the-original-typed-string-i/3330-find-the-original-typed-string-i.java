class Solution {
    public int possibleStringCount(String word) {
        HashMap<Character , Integer> mp =new HashMap<>();
        int cnt=1;
        char s[]=word.toCharArray();
        for(int i=1;i<s.length;i++){
            if(s[i]==s[i-1]) cnt++;
        }
        return cnt;
    }
}