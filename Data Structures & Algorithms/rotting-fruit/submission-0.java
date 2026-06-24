class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        Deque<int[]> dq = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        int time=0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    dq.addLast(new int[]{i,j});
                }
            }
        }
        while(!dq.isEmpty() && fresh>0){
            int level =dq.size();
            for(int i = 0; i<level; i++){
                int[] cords = dq.removeFirst();
                int r = cords[0];
                int c = cords[1];
                for(int[] dir : directions){
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if(row<0 || col<0 || row>=rows || col>=cols || grid[row][col]!=1 ){
                        continue;
                    }
                    grid[row][col]=2;
                    dq.addLast(new int[]{row,col});
                    fresh--;
                }
            }
            time++;
        }
        return fresh>0?-1:time;
    }
}
