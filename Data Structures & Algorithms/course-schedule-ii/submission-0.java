class Solution {
    HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> order = new HashSet<>();
    int[] res;
    int start=0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            adjMap.put(i,new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            adjMap.get(pre[0]).add(pre[1]);
        }
        for(int i = 0; i< numCourses; i++){
            if(!dfs(i)){
                return new int[0];
            }
        }
        return res;
    }
    public boolean dfs(int i){
        if(visited.contains(i)){
            return false;
        }
        if(order.contains(i)){
            return true;
        }
        visited.add(i);
        for(int pre: adjMap.get(i)){
            if(!dfs(pre)){
                return false;
            }
        }
        order.add(i);
        visited.remove(i);
        res[start]=i;
        start++;
        return true;
    }
}
