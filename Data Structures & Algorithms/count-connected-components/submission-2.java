class Solution {
    int[] par;
    int[] rank;

    public int countComponents(int n, int[][] edges) {

        par = new int[n];
        for(int i =0;i<n;i++){
            par[i]=i;
        }
        rank = new int[n];
        Arrays.fill(rank,1);
        int ans = n;
        for(int[] edge: edges){
            ans -= union(edge[0],edge[1]);
        }
        return ans;

    }

    int find(int n){
        int res = n;
        while(res!=par[res]){
            par[res] = par[par[res]];
            res = par[res];
        }
        return res;
    }

    int union(int n1,int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1==p2) return 0;
        if(rank[p1]>rank[p2]){
            par[p2] = par[p1];
            rank[p1] += rank[p2];
        }else{
            par[p1] = par[p2];
            rank[p2] += rank[p1];
        }
        return 1;
    }

}
