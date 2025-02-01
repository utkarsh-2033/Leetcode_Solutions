class Solution {
    public void helper(String digits,int idx, List<String> ans ,String current, String[] mapping){
        if(idx==digits.length()){
            ans.add(current);
            return;
        }
            String map=mapping[digits.charAt(idx)-'0' -2];
            for(int j=0;j<map.length();j++){
                helper(digits,idx+1,ans,current+map.charAt(j),mapping);
            }
    }
    public List<String> letterCombinations(String digits) {
        
        String mapping[]={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        helper(digits,0,ans,"",mapping);
        return ans;
    }
}