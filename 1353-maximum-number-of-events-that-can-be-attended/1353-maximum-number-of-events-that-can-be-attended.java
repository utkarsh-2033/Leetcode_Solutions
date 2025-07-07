class Solution {
    public int maxEvents(int[][] events) {
        //sorting accn to end time
        //attending event which gets completed first greedily to maximize no of events attended
        Arrays.sort(events,(a,b)->(a[1]-b[1]));
        int maxendtime=-1;
        for(int i=0;i<events.length;i++) maxendtime=Math.max(maxendtime,events[i][1]);
        int hash[]=new int[maxendtime+2];
        int c=0;
        for(int i=0;i<events.length;i++){
            // int j=events[i][0];
            for(int j=events[i][0];j<=events[i][1];j++){
                if(hash[j]==0){
                    hash[j]=i+1;
                    c++;
                    break;
                }
            }
        }
        return c;
    }
}