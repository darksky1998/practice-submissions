class Solution {
    public int uniquePaths(int m, int n) {
       int[] dp = new int[n];
       Arrays.fill(dp,1);

       for(int r = m-2; r>=0; r--){
            int[] newDp=new int[n];
            newDp[n-1]=1;
            for(int c=n-2;c>=0;c--){
                newDp[c] = newDp[c+1]+dp[c];
            }
            dp=newDp;  
       }
        return dp[0];
    }
}
