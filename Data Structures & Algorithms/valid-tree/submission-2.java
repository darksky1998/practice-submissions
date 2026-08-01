class Solution {
    HashMap<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(n==0){
            return true;
        }
        for(int i = 0; i< n;i++){
            adjMap.put(i,new ArrayList<>());
        }
        for(int[] edge: edges){
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }

        if(dfs(0,-1) && n==visited.size()){
            return true;
        } 
        else{
            return false;
        }
    }

    boolean dfs(int i, int prev){
        if(visited.contains(i)){
            return false;
        }
        visited.add(i);
        for(int node: adjMap.get(i)){
            if(node==prev){
                continue;
            }
            if(!dfs(node,i)){
                return false;
            }
        }
        return true;
    }
}
