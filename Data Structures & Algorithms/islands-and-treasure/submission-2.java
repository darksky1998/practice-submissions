class Solution {
    int ROWS = 0;
    int COLS = 0;
    Deque<List<Integer>> dq = new ArrayDeque<>();
    int layer = 0;
    public void islandsAndTreasure(int[][] grid) {
        
        ROWS = grid.length;
        COLS = grid[0].length;
        for(int r = 0; r<ROWS;r++){
            for(int c = 0;c<COLS;c++){
                if(grid[r][c]==0){
                    dq.addLast(new ArrayList<>(List.of(r,c)));
                }
            }
        }

        while(!dq.isEmpty()){
            int size = dq.size();
            layer++;
            for(int i = 0; i<size;i++){
                List<Integer> cur = dq.removeFirst();
                int cr = cur.get(0);
                int cc = cur.get(1);
                near(cr+1,cc,grid);
                near(cr-1,cc,grid);
                near(cr,cc+1,grid);
                near(cr,cc-1,grid);
            }
        }

    }

    void near(int r, int c, int[][] grid){
        if(r<0 || r>=ROWS || c<0 || c>=COLS 
        || grid[r][c]!=2147483647){
            return;
        }
        grid[r][c]=layer;
        dq.addLast(new ArrayList<>(List.of(r,c)));
    }

}
