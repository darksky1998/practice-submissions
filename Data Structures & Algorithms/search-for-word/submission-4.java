class Solution {
    private Set<Pair<Integer, Integer>> path = new HashSet<>();

    public boolean exist(char[][] board, String word) {
       int r = board.length;
       int c = board[0].length;
       for(int i=0; i<r; i++){
        for(int j = 0; j<c; j++){
            if(dfs(board,word,0,i,j)){
                return true;
            }
        }
       } 
       return false;
    }
    boolean dfs(char[][] board, String word, int w, int r, int c){
        if(w==word.length()){
            return true;
        }
        if( r<0 || r>=board.length || c<0 || c>=board[0].length || 
        w>=word.length() || word.charAt(w)!=board[r][c] || path.contains(new Pair<>(r, c))
        ){
            return false;
        }
        path.add(new Pair<>(r, c));
        boolean found =  dfs(board,word,w+1,r+1,c) || 
               dfs(board,word,w+1,r-1,c) ||
               dfs(board,word,w+1,r,c+1) || 
               dfs(board,word,w+1,r,c-1);
        path.remove(new Pair<>(r, c));
        return found;
    }
}
