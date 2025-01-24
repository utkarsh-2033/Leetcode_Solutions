class Solution {
    public boolean isPalindrome(int start,int end,String s){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
    public void partionhelper(String s,int idx,List<List<String>> ans
    ,List<String> current){
        if(idx==s.length()){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(idx,i,s)){              //range idx  to i***
                current.add(s.substring(idx,i+1));
                partionhelper(s,i+1,ans,current);
                current.remove(current.size()-1);   //backtrack
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> current=new ArrayList<>();
        partionhelper(s,0,ans,current);
        return ans;
    }
}