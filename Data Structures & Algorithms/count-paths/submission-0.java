class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row,1);

        for(int r = m-2;r>=0 ; r--){
            int[] newRow = new int[n];
            Arrays.fill(newRow,1);
            for(int j = n-2;j>=0;j--){
                newRow[j] = newRow[j+1]+row[j];
            }
            row=newRow;
        }
        return row[0];
    }
}
