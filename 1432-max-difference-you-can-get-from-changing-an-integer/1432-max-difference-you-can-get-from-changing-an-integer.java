class Solution {
    public int maxDiff(int num) {
        //similar to 2566. Maximum Difference by Remapping a Digit
        //ecept in min- cant be 0 and no leading 0
        String n=String.valueOf(num);
        //for max- finding 1st non 9 from l to r
        String max=n;
        for(char c:n.toCharArray()){
            if(c!='9'){
                max=n.replace(c,'9'); break;
            }
        }
        String min=n;
        //for min- 
        for(int i=0;i<n.length();i++){
            char c=n.charAt(i);
            if(i==0){
                if(c!='1'){
                    min=n.replace(c,'1');
                    break;
                }
            }
            //finding first non 1 
            if(c!='1' && c!='0'){
                min=n.replace(c,'0');
                break;
            }
        }
        return Integer.parseInt(max)-Integer.parseInt(min);
    }
}