class DisjointSet{
    int parent[],rank[],size[];
    DisjointSet(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i; size[i]=1;
        }
    }
    int findulp(int x){
        if(parent[x]!=x) parent[x]=findulp(parent[x]);
        return parent[x];
    }
    void unionbyrank(int x,int y){
        int upx=findulp(x);
        int upy=findulp(y);
        if(rank[upx]>rank[upy]) parent[upy]=upx;
        else if(rank[upx]<rank[upy]) parent[upx]=upy;
        else {
            parent[upx]=upy; rank[upy]++;
        }
    }
    void unionbysize(int x,int y){
        int upx=findulp(x);
        int upy=findulp(y);
        if(size[upx]>size[upy]) {parent[upy]=upx; size[upx]+=size[upy];}
        else  {parent[upx]=upy; size[upy]+=size[upx];}
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSet ds=new DisjointSet(accounts.size()); // node=persons
        HashMap<String,Integer> mp=new HashMap<>(); //{email: index(mapped to person)}
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(!mp.containsKey(mail)) mp.put(mail,i);
                else ds.unionbysize(i,mp.get(mail));
            }
        }
        List<List<String>> mergedmails=new ArrayList<>();
        for(int i=0;i<accounts.size();i++) mergedmails.add(new ArrayList<>());
        for(Map.Entry<String,Integer> it:mp.entrySet()){
            String mail=it.getKey();
            int node=ds.findulp(it.getValue());
            mergedmails.get(node).add(mail);
        }
        //creating ans in required format - list of list{name, email1,email2....}
        List<List<String>> ans=new ArrayList<>();
        for(int i=0 ;i<mergedmails.size();i++){
            if(mergedmails.get(i).size()==0) continue; //if accounts merged , that index empty 
            //since all emails of that index is merged with other same person having common email
            ArrayList<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0)); //adding name 
            Collections.sort(mergedmails.get(i)); 
            for(String mail:mergedmails.get(i)) temp.add(mail); //adding emails
            ans.add(temp);
        }
        return ans;
    }
}