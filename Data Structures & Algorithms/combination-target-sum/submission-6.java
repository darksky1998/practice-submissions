class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       Arrays.sort(nums);
       dfs(0,nums,target,0,new ArrayList<>());
       return res; 
    }

    void dfs(int i, int[] nums, int target,int curSum, List<Integer> path){
        if(curSum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        if(i>=nums.length || curSum>target){
            return;
        }
        curSum+=nums[i];
        path.add(nums[i]);
        dfs(i,nums,target,curSum,path);
        curSum-=nums[i];
        path.remove(path.size()-1);
        dfs(i+1,nums,target,curSum,path);
    }

}