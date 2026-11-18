class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0;i<n;i++){
            parent[i]=i;
        }
        int[] rank = new int[n];
        Arrays.fill(rank,1);
        int res = n;
        for(int[] edge: edges){
            int n1 = edge[0];
            int n2 = edge[1];
            res -= union(n1,n2,rank,parent);
        }
        return res;
    }

//[0,1,2,3,4]
//[1,1,1,1,1]
    int union(int n1,int n2, int[] rank, int[] par){
        int p1=find(n1,par), p2 = find(n2,par);
        if(p1==p2){
            return 0;
        }
        if(rank[p2]>rank[p1]){
            par[p1] = par[p2];
            rank[p2] +=rank[p1];
        }else{
            par[p2] = par[p1];
            rank[p1] +=rank[p2];
        }
        return 1;
    }

    int find(int n, int[] parent){
        int res = n;
        while(res != parent[res]){
            res=parent[res];
        }
        return res;
    }
}
