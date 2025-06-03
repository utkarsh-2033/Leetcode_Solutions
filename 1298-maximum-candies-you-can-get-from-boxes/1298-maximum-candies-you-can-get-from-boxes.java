class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys,
            int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean visited[] = new boolean[n];
        HashSet<Integer> found = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for (int i : initialBoxes) {
            found.add(i);
            if (status[i] == 1) {
                visited[i] = true;
                cnt += candies[i];
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int k = q.poll();
            for (int i : containedBoxes[k]) {
                if (status[i] == 1 && !visited[i]) {
                    cnt += candies[i];
                    visited[i] = true;
                    q.add(i);
                }
                found.add(i);
            }
            for (int i : keys[k]) {
                if (found.contains(i) && !visited[i]) {
                    cnt += candies[i];
                    visited[i] = true;
                    q.add(i);
                } else
                    status[i] = 1;
            }
        }
        return cnt;
    }
}