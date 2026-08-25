class Solution {
    int ROWS = 0;
    int COLS = 0;
    int fresh = 0;
    Deque<List<Integer>> dq = new ArrayDeque<>();
    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        for(int r = 0; r<ROWS;r++){
            for(int c = 0; c<COLS;c++){
                if(grid[r][c]==1){
                    fresh++;
                }
                if(grid[r][c]==2){
                    dq.addLast(new ArrayList<>(List.of(r,c)));
                }
            }
        }
        int time=0;
        while(!dq.isEmpty() && fresh!=0){
            time++;
            int size = dq.size();
            for(int i = 0; i<size;i++){
                List<Integer> cur = dq.removeFirst();
                int cr = cur.get(0);
                int cc = cur.get(1);
                rotten(cr+1,cc,grid);
                rotten(cr-1,cc,grid);
                rotten(cr,cc+1,grid);
                rotten(cr,cc-1,grid);
                if(fresh==0){
                break;
            }
            }
            if(fresh==0){
                break;
            }
        }
        if(fresh==0){
            return time;
        }else{
            return -1;
        }
    }

    void rotten(int r, int c, int[][] grid){
        if(r<0 || r>=ROWS || c<0 || c>=COLS || grid[r][c]!=1){
            return;
        }
        fresh--;
        grid[r][c]=-1;
        dq.addLast(new ArrayList<>(List.of(r,c)));
    }

}
