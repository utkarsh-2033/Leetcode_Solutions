class DisjointSet{
    int parent[];
    int rank[];
    int size[];
    DisjointSet(int n){
        this.parent=new int[n+1];
        this.rank=new int[n+1];
        this.size=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i; size[i]=1;
        }
    }
    int findup(int x){
        if(parent[x]!=x) parent[x]=findup(parent[x]);
        return parent[x];
    }
    void unionbyrank(int x,int y){
        int upx=findup(x);
        int upy=findup(y);
        if(rank[upx]>rank[upy]) parent[upy]=upx;
        else if(rank[upx]<rank[upy]) parent[upx]=upy;
        else {parent[upx]=upy; rank[upy]++;}
    }
    void unionbysize(int x,int y){
        int upx=findup(x);
        int upy=findup(y);
        if(size[upx]>size[upy]){ parent[upy]=upx; size[upx]+=size[upy];}
        else {parent[upx]=upy; size[upy]+=size[upx];}
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        DisjointSet ds=new DisjointSet(n);
        //cosidering each index i stone in the arr stones as ith named stone 
        //iterating through stones and comparing each pair to find 
        //iff they have common row or col and then only union them
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || //checking row
                   stones[i][1]==stones[j][1])   //colmn 
                   ds.unionbysize(i,j);
            }
        }
        int c=0;
        //finding number of componenets= stone having itself as it's up
        for(int i=0;i<n;i++){
            if(ds.findup(i)==i) c++;
        }
        //stones removed = total stones- no of connected components
        //from each components - all stones can be removed except one 
        return n-c;
    }
}