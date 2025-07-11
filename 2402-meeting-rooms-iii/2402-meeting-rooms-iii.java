class pair{
    int end;int room;
    pair(int end,int room){
        this.end=end;this.room=room;
    }
}
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> available=new PriorityQueue<>();
        PriorityQueue<pair> used=new PriorityQueue<>((a,b)->(a.end!=b.end)?a.end-b.end:a.room-b.room);
        int room[]=new int[n];
        for(int i=0;i<n;i++) available.offer(i);
        for(int i=0;i<meetings.length;i++){
            int start=meetings[i][0];
            int end=meetings[i][1];
            int duration=end-start;
            while(!used.isEmpty() && used.peek().end<=start) available.offer(used.poll().room);
            if(!available.isEmpty()){
                room[available.peek()]++;
                used.offer(new pair(end,available.poll()));
            }
            else{
                pair t=used.poll();
                used.offer(new pair(t.end+duration,t.room));
                room[t.room]++;
            }
        }
        int mx=-1;
        int ans=-1;
        for(int i=0;i<n;i++){
            if(mx<room[i]){
                mx=room[i];
                ans=i;
            }
        }
        return ans;
    }
}