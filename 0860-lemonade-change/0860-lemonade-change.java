class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0; //no need to track 20 as 20 cant be used in exchange 
        for(int bill:bills){
            if(bill==5) five++;
            else if(bill==10){
                if(five>0){
                    five--;
                    ten++;
                }else return false;
            }
            else{ //bill=20
                if(ten>0 && five>0){ //greedily spending higher domination first
                    ten--;
                    five--;
                }
                else if(five>2) five=five-3;
                else return false;
            }
        }
        return true;
    }
}