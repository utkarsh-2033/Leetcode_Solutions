class Solution {
    public int maxEvents(int[][] events) {
        HashSet<Integer> hs=new HashSet<>();
        Arrays.sort(events,(a,b)->(a[1]!=b[1])?a[1]-b[1]:a[0]-b[0]);
        int c=0;
        for(int i=0;i<events.length;i++){
            int start=events[i][0];
            int end=events[i][1];
            for(int j=end;j>=start;j--){
                if(!hs.contains(j)){
                    c++;
                    hs.add(j);
                    break;
                }
            }
        }
        return c;
    }
}