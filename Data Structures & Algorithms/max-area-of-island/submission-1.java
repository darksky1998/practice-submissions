class Solution {
    int max;
    Set<Pair<Integer,Integer>> visited = new HashSet<>();
    public int maxAreaOfIsland(int[][] grid) {
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                if(grid[r][c]==1){
                    dfs(grid,r,c,0);
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int r, int c, int cur){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length 
            || visited.contains(new Pair(r,c))
            || grid[r][c]==0){
                return 0;
            }
            visited.add(new Pair(r,c));
        cur=1+dfs(grid,r+1,c,cur) 
            +dfs(grid,r-1,c,cur)
            +dfs(grid,r,c+1,cur)
            +dfs(grid,r,c-1,cur);
        max = Math.max(max,cur);
        return cur;
    }
}
