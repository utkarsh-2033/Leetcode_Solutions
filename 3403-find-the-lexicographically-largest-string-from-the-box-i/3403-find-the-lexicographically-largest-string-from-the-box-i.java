class Solution {
    public String answerString(String word, int numFriends) {
        int n =word.length();
        if(numFriends == 1)  return word;
        int possiblelen =n-(numFriends - 1);
        String ans ="";
        for(int i=0;i<n;i++) {
            int len =Math.min(possiblelen, n-i);
            String s =word.substring(i,i+len);
            if (s.compareTo(ans)>0) {
                ans=s;
            }
        }
        return ans;
    }
}