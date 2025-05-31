class Solution {
    private int[] getidx(int num,int n){
        int r =(n-1)-(num-1)/n;
        int c =(num-1)%n;
        if((n-r)%2==0) c= n-1-c; //zigzag:reverse direction on even rows
        return new int[]{r,c};
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n*n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=true;
        int moves=0;

        while(!q.isEmpty()){
            int size= q.size(); //tracking:level=no of dice rolls - like trees - here 1 root - 6 childrens
            for(int i=0;i<size;i++){
                int curr =q.poll();
                if(curr== n*n) return moves;
                for(int next = curr + 1; next <= Math.min(curr+6, n*n); next++){
                    int[] idx = getidx(next, n);
                    int r = idx[0], c = idx[1];
                    int dest = board[r][c] == -1 ? next : board[r][c];
                    if(!visited[dest]){
                        visited[dest] = true;
                        q.add(dest);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
