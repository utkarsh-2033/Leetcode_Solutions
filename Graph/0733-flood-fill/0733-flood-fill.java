class Solution {
    public void dfs(int row,int col,int image[][],int initialColor,
    int newColor,int[] delrow,int[] delcol){
        image[row][col]=newColor; //marking with necolor(serve as visied as well)
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<image.length && ncol>=0 && ncol<image[0].length && 
            image[nrow][ncol]==initialColor){
                dfs(nrow,ncol,image,initialColor,newColor,delrow,delcol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        if (initialColor == color) return image; // to prevent infinite recursion
        int delrow[]={-1,0,1,0};
        int delcol[]={0,-1,0,1};
        dfs(sr,sc,image,initialColor,color,delrow,delcol);
        return image;
    }
}