class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        // timeGrid[i][j]: best known arrival time at (i,j)
        int[][] timeGrid = new int[n][m];
        for (int[] row : timeGrid) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Min-heap storing [arrivalTime, x, y]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});  
        timeGrid[0][0] = 0;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], x = cur[1], y = cur[2];

            // If we reached the target, that's the minimum time
            if (x == n - 1 && y == m - 1) return t;

            // If we’ve already found a faster way to (x,y), skip
            if (t > timeGrid[x][y]) continue;

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // Correct wait logic:
                int startMove = Math.max(t, moveTime[nx][ny]);
                int arrival   = startMove + 1;

                if (arrival < timeGrid[nx][ny]) {
                    timeGrid[nx][ny] = arrival;
                    pq.offer(new int[]{arrival, nx, ny});
                }
            }
        }

        // Should never happen on valid inputs
        return -1;
    }
}
