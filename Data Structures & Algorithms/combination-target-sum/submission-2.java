class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,target,new ArrayList<>(),0,0);
        return res;
    }
    void dfs(int nums[], int target, List<Integer> cur,int sum,int i){
        if(sum==target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(sum>target || i>= nums.length){
            return;
        }
        cur.add(nums[i]);
        dfs(nums,target,cur,sum+nums[i],i);
        cur.remove(cur.size()-1);
        dfs(nums,target,cur,sum,i+1);

    }
}
