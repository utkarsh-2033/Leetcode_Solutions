class Solution {
    public void helper(String digits,int idx, List<String> ans ,StringBuilder current, String[] mapping){
        if(idx==digits.length()){
            ans.add(current.toString());
            return;
        }
            String map=mapping[digits.charAt(idx)-'0' -2];
            for(int j=0;j<map.length();j++){
                current.append(map.charAt(j));
                helper(digits,idx+1,ans,current,mapping);
                current.deleteCharAt(current.length()-1);
            }
    }
    public List<String> letterCombinations(String digits) {
        
        String mapping[]={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        helper(digits,0,ans,new StringBuilder(),mapping);
        return ans;
    }
}