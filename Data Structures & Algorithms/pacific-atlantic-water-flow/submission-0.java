class Solution {
    Set<List<Integer>> pac = new HashSet<>();
    Set<List<Integer>> atl = new HashSet<>();
    int ROWS=0;
    int COLS=0;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        ROWS = heights.length;
        COLS = heights[0].length;
        for(int c = 0; c<COLS;c++){
            dfs(0,c,pac,heights,heights[0][c]);
            dfs(ROWS-1,c,atl,heights,heights[ROWS-1][c]);
        }
        for(int r = 0; r<ROWS;r++){
            dfs(r,0,pac,heights,heights[r][0]);
            dfs(r,COLS-1,atl,heights,heights[r][COLS-1]);
        }
        for(int r = 0;r<ROWS;r++){
            for(int c = 0;c<COLS;c++){
                if(pac.contains(List.of(r,c)) && atl.contains(List.of(r,c))){
                    res.add(List.of(r,c));
                }
            }
        }
        return res;
    }

    void dfs(int r, int c, Set<List<Integer>> visited, int[][] heights,int prevHeight){
        if(r<0 || r>=ROWS || c<0 || c>= COLS 
        || visited.contains(List.of(r,c)) || prevHeight> heights[r][c]){
            return;
        }
        visited.add(List.of(r,c));
        prevHeight = heights[r][c];
        dfs(r+1,c,visited,heights,prevHeight);
        dfs(r-1,c,visited,heights,prevHeight);
        dfs(r,c+1,visited,heights,prevHeight);
        dfs(r,c-1,visited,heights,prevHeight);
    }
}
