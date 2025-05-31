class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        ArrayList<Integer> arr=new ArrayList<>();
        ArrayList<Integer> temp;
        arr.add(1);
        arr.add(1);
        for(int i=1;i<n-1;i++){
            int size=arr.size();
            temp=new ArrayList<>();
            int count=0,num=-1;
            for(int j=0;j<size;j++){
                if(arr.get(j)==num) count++;
                else{
                    if(j!=0){
                        temp.add(count);
                        temp.add(num);
                    }
                    count=1;
                    num=arr.get(j);
                }
            }
            temp.add(count);
            temp.add(num);
            arr=temp;
        }
        StringBuilder ans=new StringBuilder();
        for(int i:arr) ans.append(i);
        return ans.toString();
    }
}