class Solution {
    public boolean backtrack(char[][] board,String word,int row,int col,int n,int idx , int rows , int cols){
        if(idx==n) return true;
        char temp = board[row][col];
        board[row][col] = '#';
        if(row+1<rows && board[row+1][col]==word.charAt(idx)){ //down 
            if(backtrack(board,word,row+1,col,n,idx+1,rows,cols)) return true;
        }
        if(row-1>=0 && board[row-1][col]==word.charAt(idx)){  //up

            if(backtrack(board,word,row-1,col,n,idx+1,rows,cols)) return true;
        }
        if(col-1>=0 && board[row][col-1]==word.charAt(idx)){ //left
            if(backtrack(board,word,row,col-1,n,idx+1,rows,cols)) return true;
        }
        if(col+1<cols && board[row][col+1]==word.charAt(idx)){ //right
            if(backtrack(board,word,row,col+1,n,idx+1,rows,cols)) return true;
        }
        board[row][col] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        int i,j;
        for(i=0;i<rows;i++){
            for(j=0;j<cols;j++){
                if(board[i][j]==word.charAt(0)){
                    if(backtrack(board,word,i,j,word.length(),1,rows , cols)) return true;
                }
            }
        }
        return false;
    }
}