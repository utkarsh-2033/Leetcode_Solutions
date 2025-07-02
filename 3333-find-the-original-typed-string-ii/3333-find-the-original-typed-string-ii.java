class Solution {
    int M=(int)1e9+7;
    int solve(int idx,int cnt,ArrayList<Integer> freq,int k,int dp[][]){
        if(idx>=freq.size()){
            if(cnt<k) return 1;
            return 0;
        }
        if(dp[idx][cnt]!=-1) return dp[idx][cnt];
        int result=0;
        for(int i=1;i<=freq.get(idx);i++){
            if(cnt+i<k){
                result=(result+solve(idx+1,cnt+i,freq,k,dp))%M;
            }else break;
        }
        return dp[idx][cnt]=result;
    }
    public int possibleStringCount(String word, int k) {
        ArrayList<Integer> freq=new ArrayList<>();
        int cnt=1;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)==word.charAt(i-1)) cnt++;
            else {
                freq.add(cnt);
                cnt=1;
            }
        }
        freq.add(cnt);
        int total=1;
        for(int i:freq){
            total=(total*i)%M;
        }
        if(freq.size()>=k) return total;
        int dp[][]=new int[word.length()+1][word.length()+1];
        for(int i=0;i<word.length()+1;i++){
            Arrays.fill(dp[i],-1);
        }
        int invalid=solve(0,0,freq,k,dp);
        return (total-invalid +M)%M;
    }
}