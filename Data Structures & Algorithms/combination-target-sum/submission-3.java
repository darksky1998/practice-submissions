class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,target,new ArrayList<>(),0,0);
        return res;
    }
    void dfs(int[] nums, int target, List<Integer> cur, int curSum, int i){
        if(curSum==target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(i>=nums.length || curSum>target){
            return;
        }
        cur.add(nums[i]);
        dfs(nums,target,cur,curSum+nums[i],i);
        cur.remove(cur.size()-1);
        dfs(nums,target,cur,curSum,i+1);

    }
}
