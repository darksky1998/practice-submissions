class Solution {
    int max;
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
            || grid[r][c]==0){
                return 0;
            }
            grid[r][c] = 0;
        cur=1+dfs(grid,r+1,c,cur) 
            +dfs(grid,r-1,c,cur)
            +dfs(grid,r,c+1,cur)
            +dfs(grid,r,c-1,cur);
        max = Math.max(max,cur);
        return cur;
    }
}
