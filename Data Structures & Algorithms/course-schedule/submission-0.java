class Solution {

    Set<Integer> visited = new HashSet<>();
    HashMap<Integer,List<Integer>> adjMap= new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            adjMap.put(i,new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            adjMap.get(pre[0]).add(pre[1]);
        }
        for(int i = 0; i<numCourses; i++){
            System.out.println("dfs for "+i+" "+adjMap.get(i));
            if(!dfs(i)){
                return false;
            }
        }
        return true;

    }
    public boolean dfs(int i){
        if(visited.contains(i)){
            System.out.println("cycle for "+i);
            return false;
        }
        if(adjMap.get(i).size()==0){
            System.out.println("empty for "+i);
            return true;
        }
        visited.add(i);
        for(int pre: adjMap.get(i)){
            System.out.println(pre);
            if(!dfs(pre)){
                return false;
            }
            System.out.println("true for "+pre);
        }
        visited.remove(new Integer(i));
        adjMap.put(i,new ArrayList<>());
        System.out.println("new adj "+adjMap.get(i));
        return true;
    }
}
