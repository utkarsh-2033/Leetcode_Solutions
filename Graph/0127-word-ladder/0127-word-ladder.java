class Solution {
    class pair{
        String word; int num;
        pair(String word,int num){
            this.word=word; this.num=num;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st=new HashSet<>(); //for o(1) lookup of wordlist
        for(String word:wordList) st.add(word);
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(beginWord,1));
        while(!q.isEmpty()){
            pair p=q.poll();
            String word=p.word;
            int num=p.num;
            if(p.word.equals(endWord)) return num;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] arr=word.toCharArray();
                    arr[i]=ch;
                    String newword=new String(arr);
                    if(st.contains(newword)){
                        q.offer(new pair(newword,num+1));
                        st.remove(newword);
                    }
                }
            }
        }
        return 0;
    }
}