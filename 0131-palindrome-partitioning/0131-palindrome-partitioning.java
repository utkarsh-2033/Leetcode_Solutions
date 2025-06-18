class Solution {
    private boolean palindromeCheck(String s){
        int n=s.length()-1;
        int l=0;
        while(l<=n){
            if(s.charAt(l)!=s.charAt(n)) return false;
            l++;n--;
        }
        return true;
    }
    private void f(int idx,String s,List<List<String>> ans,ArrayList<String> curr){
        if(idx==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<s.length();i++){
            //partioning at i+1
            String st=s.substring(idx,i+1);
            if(palindromeCheck(st)){
                curr.add(st);
                f(i+1,s,ans,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        ArrayList<String> curr=new ArrayList<>();
        f(0,s,ans,curr);
        return ans;
    }
}