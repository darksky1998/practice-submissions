class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return res;
    }
    void dfs(int[] nums, int i, List<Integer> cur){
        if(i>=nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        dfs(nums,i+1,cur);
        cur.remove(cur.size()-1);
        dfs(nums,i+1,cur);
    }
}
