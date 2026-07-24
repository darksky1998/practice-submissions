class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    int rows = 0;
    int cols = 0;
    HashSet<List<Integer>> visited = new HashSet<>();
    Deque<int[]> dq = new ArrayDeque<>();

    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j]==0){
                    dq.addLast(new int[]{i,j});
                    visited.add(Arrays.asList(i,j));
                }
            }
        }
        int dist = 0;
        while(!dq.isEmpty()){
            int dqLen = dq.size();
            for(int i = 0; i<dqLen;i++){
                int[] coords = dq.removeFirst();
                grid[coords[0]][coords[1]] = dist;
                add(coords[0],coords[1]+1,dist,grid);
                add(coords[0],coords[1]-1,dist,grid);
                add(coords[0]+1,coords[1],dist,grid);
                add(coords[0]-1,coords[1],dist,grid);
            }
            dist+=1;
        }
    }
    void add(int i, int j, int dist, int[][] grid){
        if(i<0 || i>=rows || j<0 || j>=cols || visited.contains(Arrays.asList(i,j))
        || grid[i][j]!=2147483647){
            return;
        }
        System.out.println(i+" "+j);
        visited.add(Arrays.asList(i,j));
        dq.add(new int[]{i,j});
    }
}
