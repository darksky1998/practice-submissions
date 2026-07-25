class Solution {
    int rows =0;
    int cols = 0;
    int fresh = 0;
    Set<List<Integer>> visited = new HashSet<>();
    Deque<int[]> dq = new ArrayDeque<>();
    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for(int r = 0; r< rows;r++){
            for(int c = 0; c<cols;c++){
                if(grid[r][c]==1){
                    fresh++;
                }
                if(grid[r][c]==2){
                    dq.addLast(new int[]{r,c});
                    visited.add(Arrays.asList(r,c));
                }
            }
        }
        int time = 0;
        System.out.println("iinitial "+time+" "+fresh);
        while(!dq.isEmpty() && fresh>0){
            int size = dq.size();
            time=time+1;
            System.out.println("start of "+time+" "+fresh);
            for(int i = 0; i<size && fresh>0;i++){
                int[] coords = dq.removeFirst();
                traverse(coords[0]+1,coords[1],grid);
                traverse(coords[0]-1,coords[1],grid);
                traverse(coords[0],coords[1]+1,grid);
                traverse(coords[0],coords[1]-1,grid);
                System.out.println(time+" "+fresh);
            }
            System.out.println("end of "+time+" "+fresh);
        }
        if(fresh ==0){
            return time;
        }
        else
            return -1;
    }
    void traverse(int r, int c, int[][] grid){
        if(r<0 || r>= rows || c<0 || c>=cols || 
        visited.contains(Arrays.asList(r,c)) || grid[r][c]!=1){
            return;
        }
        fresh--;
        grid[r][c]=2;
        dq.add(new int[]{r,c});
        visited.add(Arrays.asList(r,c));
    }
}
