class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int r = coins.length-1; r>=0; r--){
            int[] newDp = new int[amount+1];
            for(int c = 0; c<=amount; c++){
                newDp[c] = dp[c];
                if(c-coins[r]>=0){
                    newDp[c] += newDp[c-coins[r]];
                }
            }
            dp=newDp;
        }
        return dp[amount];
    }
}
