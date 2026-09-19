class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row,1);
        for(int r = m-2; r>=0; r--){
            int[] newRow = new int[n];
            Arrays.fill(newRow,1);
            for(int c = n-2;c>=0;c--){
                newRow[c]=newRow[c+1]+row[c];
            }
            row = newRow;
        }
        return row[0];
    }
}
