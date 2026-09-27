class Solution {
    int ROWS;
    int COLS;
    Deque<List<Integer>> dq = new ArrayDeque<>();
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for(int r = 0; r<ROWS; r++){
            for(int c = 0; c<COLS; c++){
                if(grid[r][c]==0){
                    dq.addLast(Arrays.asList(r,c));
                }
            }
        }
        while(!dq.isEmpty()){
            int size = dq.size();
            int level = 1;
            for(int i = 0; i<dq.size(); i++){
                List<Integer> cur = dq.removeFirst();
                int r = cur.get(0);
                int c = cur.get(1);
                nearest(r+1,c,grid,level,grid[r][c]);
                nearest(r-1,c,grid,level,grid[r][c]);
                nearest(r,c+1,grid,level,grid[r][c]);
                nearest(r,c-1,grid,level,grid[r][c]);
            }
            level++;
        }
    }
    void nearest(int r, int c, int[][] grid,int level,int prev){
        if(r<0 || r>=ROWS || c<0 || c>=COLS
           || grid[r][c]!=2147483647){
            return;
        }
        grid[r][c]=level+prev;
        dq.addLast(Arrays.asList(r,c));
        return;
    }
}
