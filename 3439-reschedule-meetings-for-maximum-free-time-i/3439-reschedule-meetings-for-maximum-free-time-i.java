class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n=startTime.length;
        //storing all free times
        ArrayList<Integer> gaps=new ArrayList<>();
        int lend=0;
        for(int i=0;i<n;i++){
            int gap=startTime[i]-lend;
            gaps.add(gap);
            lend=endTime[i];
        }
        gaps.add(eventTime-endTime[n-1]);
        //1 shift => 2 free time to combine
        //finding max in window size k+1
        if(gaps.size()==0) return 0;
        int l=0,r=0;
        int ans=gaps.get(0);
        int s=0;
        while(r<gaps.size()){
            if(r-l+1>k+1){
                s=s-gaps.get(l);
                l++;
            }
            s+=gaps.get(r);
            if(s>ans) ans=s;
            r++;
        }
        return ans;
    }
}