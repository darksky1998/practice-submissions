class Solution {
    HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(n==0){
            return true;
        }
        for(int i = 0; i<n;i++){
            adjMap.put(i,new ArrayList<>());
        }
        for(int[] edge: edges){
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }
        if(dfs(0,-1) && visited.size()==n){
            return true;
        }
        return false;
    }
    boolean dfs(int cur, int prev){
        if(visited.contains(cur)){
            return false;
        }
        visited.add(cur);
        for(int next: adjMap.get(cur)){
            if(next==prev){
                continue;
            }
            if(!dfs(next,cur)){
                return false;
            }
        }
        return true;
    }
}
