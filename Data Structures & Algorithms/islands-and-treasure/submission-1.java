class Solution {
    Deque<List<Integer>> dq = new ArrayDeque<>(); 
    int ROWS = 0;
    int COLS = 0;
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        for(int r = 0; r<ROWS;r++){
            for(int c = 0; c<COLS; c++){
                if(grid[r][c]==0){
                    dq.addLast(new ArrayList<>(List.of(r,c)));
                }
            }
        }
        int dist = 0;
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i = 0; i< size;i++){
                List<Integer> coords = dq.removeFirst();
                int r = coords.get(0);
                int c = coords.get(1);
                grid[r][c]+=dist;
                calc(r+1,c,grid);
                calc(r-1,c,grid);
                calc(r,c+1,grid);
                calc(r,c-1,grid);
            }
            dist++;
        }
    }

    void calc(int r, int c, int[][] grid){
        if(r<0 || r>= ROWS || c<0 || c>=COLS
           || grid[r][c]!=2147483647 ){
            //System.out.println("inside calc for r:"+r+" c:"+c+"grid[r][c]: "+grid[r][c]);
            return;
        }
        System.out.println("inside calc for r:"+r+" c:"+c+"grid[r][c]: "+grid[r][c]);
        grid[r][c]=0;
        dq.addLast(new ArrayList<>(List.of(r,c)));
    }
}
