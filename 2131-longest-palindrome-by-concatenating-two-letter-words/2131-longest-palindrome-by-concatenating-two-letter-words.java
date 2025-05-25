class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> mp=new HashMap<>();
        for(String word :words){
            mp.put(word,mp.getOrDefault(word,0)+1);
        }

        int len=0;
        boolean Center=false;
        for(String word :mp.keySet()){
            String rev=new StringBuilder(word).reverse().toString();
            int count=mp.get(word);
            if(!word.equals(rev)){
                if(mp.containsKey(rev)){
                    int pairs=Math.min(count,mp.get(rev));
                    len+=4*pairs;
                    mp.put(word,count-pairs);
                    mp.put(rev,mp.get(rev)-pairs);
                }
            }else {
                len+=4*(count/2);
                if(count%2==1){
                    Center=true; 
                }
            }
        }
        if (Center) len += 2;
        return len;
    }
}
