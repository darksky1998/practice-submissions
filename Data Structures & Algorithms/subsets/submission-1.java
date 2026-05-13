class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums,new ArrayList<>());
        return res;
    }
    void dfs(int i, int[] nums, List<Integer> path){
        if(i>=nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        dfs(i+1,nums,path);
        path.remove(new Integer(nums[i]));
        dfs(i+1,nums,path);
    }
}
