class Solution {
    HashMap<String,Integer> dp = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(0,0,target,nums);
    }
    int backtrack(int i, int cur_sum,int target, int[] nums){
        if(i==nums.length){
            if(cur_sum==target){
                return 1;
            }else{
                return 0;
            }
        }
        String key = i+"-"+cur_sum;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        dp.put(key,
        backtrack(i+1,cur_sum+nums[i],target,nums)
        + backtrack(i+1,cur_sum-nums[i],target,nums));
        return dp.get(key);
    }
}
