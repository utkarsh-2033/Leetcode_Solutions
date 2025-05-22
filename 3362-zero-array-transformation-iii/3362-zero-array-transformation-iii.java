class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n=nums.length;
        int m=queries.length;
        //Min-heap for used queries (stores end indices)
        PriorityQueue<Integer> pastQueries=new PriorityQueue<>();

        //Max-heap for available queries (stores end indices)
        PriorityQueue<Integer> avail=new PriorityQueue<>((a,b)->b-a);

        //Sorting queries by start index
        Arrays.sort(queries,(a, b)->a[0]-b[0]);
        int j=0;               // Pointer :iterating on queries
        int usedCount=0;       // count of queries used

        for (int i=0; i<n; i++) {
            //Pushing all queries starting at index i
            while (j < m && queries[j][0] == i) {
                avail.offer(queries[j][1]);  //end index
                j++;
            }

            //Apply effect of already used queries
            nums[i]-=pastQueries.size();

            //Apply more queries if needed
            while (nums[i] > 0 && !avail.isEmpty() && avail.peek() >= i) {
                int r = avail.poll();
                pastQueries.offer(r);
                usedCount++;
                nums[i]--;
            }
            //nums[i]=0 not possible
            if (nums[i] > 0)
                return -1;
            //Removing expired queries
            while (!pastQueries.isEmpty() && pastQueries.peek() == i) {
                pastQueries.poll();
            }
        }

        return m-usedCount;
    }
}