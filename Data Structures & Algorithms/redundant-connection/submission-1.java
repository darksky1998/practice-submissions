class Solution {
    HashMap<Integer,List<Integer>> adjMap = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public int[] findRedundantConnection(int[][] edges) {
        for(int i =1;i<=edges.length;i++){
            adjMap.put(i,new ArrayList<>());
        }
        for(int[] edge: edges){
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
            visited = new HashSet<>();
            if(!dfs(edge[0],-1)){
                return edge;
            }
        }
        return new int[0];

    }
    boolean dfs(int cur, int prev){
        if(visited.contains(cur)){
            return false;
        }
        visited.add(cur);
        for(int next : adjMap.get(cur)){
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
