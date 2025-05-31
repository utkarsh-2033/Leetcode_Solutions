class Solution {
    static int M=(int)1e9+7;
    //since no of rows is less - taking column as a state 
    private void generateRows(int m,char prevColor,String s,
    char []colors,ArrayList<String> cols){
        if(s.length()==m) {
            cols.add(s);
            return;
        }
        for(char ch: colors){
            if(prevColor==ch) continue;
            generateRows(m,ch,s+ch,colors,cols);
        }
    }
    //states - idx and remaining
    private int solve(int idx,int remaining,ArrayList<String> cols,int m,int dp[][]){
        if(remaining==0) return 1;
        if(dp[remaining][idx]!=-1) return dp[remaining][idx];
            int ways=0;
        for(int i=0;i<cols.size();i++){
            if(i==idx) continue;
            boolean valid=true;
            for(int j=0;j<m;j++){
                if(cols.get(idx).charAt(j)==cols.get(i).charAt(j)){
                    valid=false; break;
                }
            }
            if(valid){
                ways=(ways+solve(i,remaining-1,cols,m,dp))%M;
            }
        }
        return dp[remaining][idx]=ways;
    }
    public int numOfWays(int n) {
        ArrayList<String> cols=new ArrayList<>();
        char colors[]={'R','Y','G'};
        generateRows(3,'l',"",colors,cols);
        int ways=0;
        int dp[][]=new int[n+1][cols.size()+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        for(int i=0;i<cols.size();i++){
            ways=(ways+solve(i,n-1,cols,3,dp))%M;
        }
        return ways;
    }
}