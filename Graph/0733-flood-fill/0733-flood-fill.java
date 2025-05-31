class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q=new LinkedList<>();
        //{row,col};
        q.offer(new int[]{sr,sc});
        int orgcolor=image[sr][sc];
        image[sr][sc]=color;
        if(orgcolor==color) return image;
        int delr[]={1,0,-1,0};
        int delc[]={0,-1,0,1};
        while(!q.isEmpty()){
            int []curr=q.poll();
            for(int i=0;i<4;i++){
                int r=delr[i]+curr[0];
                int c=delc[i]+curr[1];
                if(r<image.length && c<image[0].length && r>=0 && c>=0){
                    if(image[r][c]==orgcolor){
                        image[r][c]=color;
                        q.offer(new int[]{r,c});
                    }
                }
            }
        }
        return image;
    }
}