class Solution {
    Set<Integer> cols = new HashSet<Integer>();
    Set<Integer> posDia = new HashSet<Integer>();
    Set<Integer> negDia = new HashSet<Integer>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        dfs(board,0);
        return res;
    }
    void dfs(char[][] board, int r){
        if(r==board.length){
            List<String> rows = new ArrayList<>();
            for(int i = 0; i< board.length;i++){
                StringBuilder sb = new StringBuilder("");
                for(int j =0;j<board.length;j++){
                    sb.append(String.valueOf(board[i][j]));
                }
                rows.add(sb.toString());
            }
            res.add(rows);
        }
        for(int c = 0; c<board.length;c++){
            if(cols.contains(c) || posDia.contains(r+c) || negDia.contains(r-c)){
                continue;
            }

            board[r][c] = 'Q';
            cols.add(c);
            posDia.add(r+c);
            negDia.add(r-c);

            dfs(board,r+1);

            board[r][c] = '.';
            cols.remove(c);
            posDia.remove(r+c);
            negDia.remove(r-c);

        }
    }
}
