class Solution {
    int ROW =0;
    int COL = 0;
    public int numIslands(char[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        int island = 0;
        for(int r = 0; r<ROW;r++){
            for(int c = 0; c<COL; c++){
                if(grid[r][c]=='1'){
                    island++;
                    dfs(r,c,grid);
                }
            }
        }
        return island;
    }
    void dfs(int r, int c, char[][] grid){
        if(r<0 || r>=ROW || c<0 || c>=COL || grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        dfs(r+1,c,grid);
        dfs(r-1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);

    }
}
