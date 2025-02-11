class Solution {
    public boolean checkValidString(String s) {
        //two counter approach-range of possible open brackets
        int min=0; //to keep track of minimum possible number of "open" brackets at any idx
        int max=0; //to keep track of maximum possible number of "open" brackets at any idx
        for(char ch:s.toCharArray()){
            if(ch=='('){
                min++; max++;
            }
            else if(ch==')'){
                min=Math.max(0,min-1); //cant be negative;
                max--;
            }
            else{ //"*"
                min=Math.max(0,min-1); // * -> ) or ""
                max++;  // * -> (
            }
            if(max<0) return false;
        }
        return min==0;   //min=0 => all open brackets satisfied
    }
}