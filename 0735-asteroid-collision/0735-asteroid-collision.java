class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Stack<Integer> st =new Stack<>();
        ArrayList<Integer> ans =new ArrayList<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0) ans.add(asteroids[i]);
            else{
                while(ans.size()!=0 && ans.get(ans.size()-1)>0 &&  ans.get(ans.size()-1)<Math.abs(asteroids[i])) ans.remove(ans.size()-1);
                if(ans.size()==0 || ans.get(ans.size()-1)<0) ans.add(asteroids[i]);
                else if(ans.get(ans.size()-1)<=Math.abs(asteroids[i])) ans.remove(ans.size()-1);
            }
        }
        int n[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            n[i]=ans.get(i);
        }
        return n;
    }
}