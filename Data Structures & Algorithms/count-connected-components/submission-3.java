class Solution {
    HashMap<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        int res=0;
        for(int i = 0; i< n ;i++){
            adjMap.put(i,new ArrayList<>());
        }
        for(int[] edge : edges){
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }

        for(int i =0;i<n;i++){
            if(!visited.contains(i)){
                dfs(i);
                res++;
            }
        }
        return res;

    }

    void dfs(int i){
        if(visited.contains(i)){
            return;
        }
        visited.add(i);
        for(int adj: adjMap.get(i)){
            dfs(adj);
        }

    }
}
