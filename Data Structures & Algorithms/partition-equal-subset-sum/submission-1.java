class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int n: nums){
            target += n;
        }
        if(target%2!=0){
            return false;
        }
        target = target/2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for(int i = nums.length-1;i>=0;i--){
            Set<Integer> nextDp = new HashSet<>();
            for(int t: dp){
                nextDp.add(t+nums[i]);
                nextDp.add(t);
                if(nextDp.contains(target)){
                    return true;
                }
            }
            dp=nextDp;
        }
        return false;
    }
}
