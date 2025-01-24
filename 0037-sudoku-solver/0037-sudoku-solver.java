class Solution {
    public boolean isValid(int row,int col,char num,char board[][]){
        for(int i=0;i<9;i++){
            if(board[i][col]==num) return false;
            if(board[row][i]==num) return false;
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)]==num) return false;
        }
        return true;
    }
    //explores one possible solution path completely before backtracking-dfs
    //Each recursive call fixes one cell and moves to the next empty cell.

    public boolean solve(char board[][],int row){
        for(int i=row;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isValid(i,j,(char)k,board)){
                            board[i][j]=(char)k;
                            if(solve(board,0)) return true;
                            else board[i][j]='.';
                        }
                    }
                    return false; // If no valid number fits
                }
            }
        } 
        return true;// Solved successfully
    }
    public void solveSudoku(char[][] board) {
        if(solve(board,0)) return;
    }
}