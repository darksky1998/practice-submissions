class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,new ArrayList<>(),0);
        return res;
    }
    void dfs(int[] nums, List<Integer> cur, int i){
        if(i>=nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        dfs(nums,cur,i+1);
        cur.remove(cur.size()-1);
        dfs(nums,cur,i+1);
    }

}
