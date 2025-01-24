class Solution {

    public List<String> construct(String board[][]){
        List<String> result=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
        String s="";
            for (int j = 0; j < board.length; j++) {
                s+=board[i][j];
            }
            result.add(s);
        }
        return result;
    }

    public void solveQueensHelper(int n,int col,List<List<String>> ans
     ,String board[][],int []hashrow,int []hashDiagonalUp ,int []hashDiagonalDown){
        if(col==n){
            ans.add(construct(board));
        }
        for(int row=0;row<n;row++){
            if(hashrow[row]==0 && hashDiagonalUp[n-1+(row-col)]==0 && hashDiagonalDown[row+col]==0){
                board[row][col]="Q";
                hashrow[row]=1; hashDiagonalUp[n-1+(row-col)]=1; hashDiagonalDown[row+col]=1;
                solveQueensHelper(n,col+1,ans,board,hashrow,hashDiagonalUp,hashDiagonalDown);
                board[row][col]=".";
                hashrow[row]=0; hashDiagonalUp[n-1+(row-col)]=0; hashDiagonalDown[row+col]=0;
            }
        }
     }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> current = new ArrayList<>();
        String board[][] = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]=".";
            }
        }
        int hashrow[]=new int[n];
        int hashDiagonalUp[]=new int [2*n-1];
        int hashDiagonalDown[]=new int [2*n-1];
        solveQueensHelper(n,0,ans,board,hashrow,hashDiagonalUp,hashDiagonalDown);
        return ans;
    }
}