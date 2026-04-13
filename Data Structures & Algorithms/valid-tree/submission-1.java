class Solution {
    Map<Integer,List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<Integer>();
    public boolean validTree(int n, int[][] edges) {
        if(n<=0) return true;
        for(int i = 0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if(dfs(0,-1) && visited.size()==n){
            return true;
        }
        return false;

    }

    boolean dfs(int i, int prev){
        if(visited.contains(i)){
            return false;
        }
        visited.add(i);
        for(int e: adj.get(i)){
            if(prev==e){
                continue;
            }
            if(!dfs(e,i))return false;
        }
        return true;
    }

}
