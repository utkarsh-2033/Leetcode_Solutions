class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(char ch : s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int maxodd=Integer.MIN_VALUE,mineven=Integer.MAX_VALUE;
        for(int i:mp.values()){
            if(i%2==0){
                mineven=Math.min(mineven,i);
            } else maxodd=Math.max(maxodd,i);
        }
        return maxodd-mineven;
    }
}