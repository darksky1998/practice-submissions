class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = nums.length-2; i>=0; i--){
            for(int j = i+1; j<nums.length;j++){
                if(nums[i]<nums[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            //System.out.println(i+" "+dp[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
