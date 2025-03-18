class Disjoint{
    int parent[],rank[],size[];
    Disjoint(int n){
        this.parent=new int[n+1];
        this.rank=new int[n+1];
        this.size=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    //finding ultimate parent
    int findup(int x){
        if(parent[x]!=x) 
            parent[x]=findup(parent[x]); //path compression
        return parent[x];
    }
    void unionbyrank(int x,int y){
        int upx=findup(x);
        int upy=findup(y);
        if(upx==upy) return;
        if(rank[upx]>rank[upy]){
            parent[upy]=upx;
        }
        else if(rank[upx]<rank[upy]){
             parent[upx]=upy;
        }
        else{
            parent[upx]=upy;
            rank[upy]++; // only increased if both have same rank
        }
    }
    void unionbysize(int x,int y){
        int upx=findup(x);
        int upy=findup(y);
        if(upx==upy) return;
        if(size[upx]>size[upy]){
            parent[upy]=upx;
            size[upx]+=size[upy];
        }else{
            parent[upx]=upy;
            size[upy]+=size[upx];
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        //ans=no of comp to be conected - 1
        //possible iff extraedges>=ans 
        //1 operation = removing 1 existing edge and making a new edge to join componenets
        
        Disjoint ds=new Disjoint(n);
        int extraedges=0;
        for(int edge[]:connections){
            int a=edge[0];
            int b=edge[1];
            int pa=ds.findup(a);
            int pb=ds.findup(b);
            if(pa==pb) extraedges++;
            else ds.unionbysize(a,b);  
        }
        //no of componenets= vertices with parent of itself
        int nc=0;
        for(int i=0;i<n;i++){
            if(ds.findup(i)==i) nc++;
        }
        return (extraedges>=nc-1)? nc-1:-1;
    }
}