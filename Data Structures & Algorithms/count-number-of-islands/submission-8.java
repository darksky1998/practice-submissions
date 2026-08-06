class Solution {
    int ROWS = 0;
    int COLS = 0;
    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int count = 0;
        for(int r = 0; r<ROWS;r++){
            for(int c = 0; c<COLS;c++){
                if(grid[r][c]=='1'){
                    dfs(r,c,grid);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int r, int c, char[][] grid){
        if(r<0 || r==ROWS || c<0 || c==COLS
        || grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        dfs(r+1,c,grid);
        dfs(r-1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);
    }
}
