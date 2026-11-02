class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0] = 0;

        for(int t = 1; t<=n; t++){
            for(int sq = 1; sq*sq<=n; sq++){
                if(t-(sq*sq)>=0){
                    dp[t] = Math.min(dp[t],1+dp[t-(sq*sq)]);
                }
               // System.out.println(t+" "+sq*sq+" "+dp[t]);
            }
        }
        return dp[n]==n+1?-1:dp[n];

    }
}