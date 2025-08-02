class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int n=basket1.length;
        int minValue=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            mp.put(basket1[i],mp.getOrDefault(basket1[i],0)+1);
            mp.put(basket2[i], mp.getOrDefault(basket2[i],0)-1);
            minValue=Math.min(minValue, Math.min(basket1[i],basket2[i]));
        }
        List<Integer> arr = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry :mp.entrySet()) {
            int fruit = entry.getKey();
            int diff = entry.getValue();
            if (diff %2!=0) return -1;
            int count = Math.abs(diff)/2;
            for(int i=0;i<count;i++){
                arr.add(fruit);
            }
        }
        if(arr.size()%2!=0) return -1;
        Collections.sort(arr);
        long cost=0;
        for (int i=0;i<arr.size()/2;i++) {
            cost+=Math.min(arr.get(i),2*minValue);
        }
        return cost;
    }
}