class Solution {
    static int M=(int)1e9+7;
    //since no of rows is less - taking column as a state 
    private void generateColumns(int m,char prevColor,String s,
    char []colors,ArrayList<String> cols){
        if(s.length()==m) {
            cols.add(s);
            return;
        }
        for(char ch: colors){
            if(prevColor==ch) continue;
            generateColumns(m,ch,s+ch,colors,cols);
        }
    }
    //states - k and remaining
    private int solve(int idx,int remaining,ArrayList<String> cols,int m,int dp[][]){
        if(remaining==0) return 1;
        if(dp[idx][remaining]!=-1) return dp[idx][remaining];
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
        return dp[idx][remaining]=ways;
    }
    public int colorTheGrid(int m, int n) {
        ArrayList<String> cols=new ArrayList<>();
        char colors[]={'R','G','B'};
        generateColumns(m,'l',"",colors,cols);
        int ways=0;
        int dp[][]=new int[cols.size()+1][n+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        for(int i=0;i<cols.size();i++){
            ways=(ways+solve(i,n-1,cols,m,dp))%M;
        }
        return ways;
    }
}