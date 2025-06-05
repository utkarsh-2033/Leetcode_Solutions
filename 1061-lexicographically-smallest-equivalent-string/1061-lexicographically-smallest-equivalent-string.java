class DisjointSet {
    int parent[], rank[], size[];

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i] =0;
            size[i] =1;
        }
    }
    int find(int x) {
        if (parent[x]!=x)  parent[x]=find(parent[x]);
        return parent[x];
    }

    void unionBySize(int u, int v) {
        int pu=find(u),pv=find(v);
        if (pu==pv) return;
        // Always attaching larger lex char to smaller one
        if (pu<pv) {
            parent[pv] = pu;
            size[pu] += size[pv];
        }else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DisjointSet dsu = new DisjointSet(26);
        for (int i=0;i<s1.length();i++) {
            int u=s1.charAt(i)-'a';
            int v=s2.charAt(i)-'a';
            dsu.unionBySize(u, v);
        }
        StringBuilder sb=new StringBuilder();
        for(char ch :baseStr.toCharArray()) {
            int smallest =dsu.find(ch -'a');
            sb.append((char)(smallest +'a'));
        }
        return sb.toString();
    }
}

