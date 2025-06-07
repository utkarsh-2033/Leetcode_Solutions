class pair {
    char ch;
    int idx;

    pair(char ch, int idx) {
        this.ch = ch;
        this.idx = idx;
    }
}

class Solution {
    public String clearStars(String s) {
        int n=s.length();
        char st[]=s.toCharArray();
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->(a.ch==b.ch)? b.idx-a.idx : a.ch-b.ch);
        for(int i=0;i<n;i++){
            char ch=st[i];
            if(ch=='*'){
                st[pq.poll().idx]='*';
            }else pq.offer(new pair(ch,i));
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            if(st[i]!='*') ans.append(st[i]);
        }
        return ans.toString();
    }
}