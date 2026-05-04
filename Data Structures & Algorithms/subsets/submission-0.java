class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(new ArrayList<>(),0,nums);
        return res;
    }
    void dfs(List<Integer> path, int i, int[] nums){
        if(i==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        dfs(path,i+1,nums);
        path.remove(new Integer(nums[i]));

        dfs(path,i+1,nums);
    }
}
