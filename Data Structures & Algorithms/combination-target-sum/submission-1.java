class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,target,0,0,new ArrayList<>());
        return res;
    }

    void dfs(int[] nums, int target,int i, int cur, List<Integer> path){
        if(cur==target){
            res.add(new ArrayList<>(path));
            return;
        }
        if(i>=nums.length || cur>target){
            return;
        }
        path.add(nums[i]);
        dfs(nums,target,i,cur+nums[i],path);
        path.remove(new Integer(nums[i]));
        dfs(nums,target,i+1,cur,path);
    }
}
