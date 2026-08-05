class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(0,nums,target,new ArrayList<>(),0);
        return res;
    }
    void dfs(int i, int[] nums, int target, List<Integer> path, int curSum){
        if(curSum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        if(i>=nums.length || curSum>target){
            return;
        }
        curSum+=nums[i];
        path.add(nums[i]);
        dfs(i,nums,target,path,curSum);
        curSum-=nums[i];
        path.remove(new Integer(nums[i]));
        dfs(i+1,nums,target,path,curSum);
    }
}
