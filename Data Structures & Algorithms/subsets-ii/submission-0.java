class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>());
        return res;
    }

    void dfs(int[] nums, int i, List<Integer> path){
        if(i==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        dfs(nums,i+1,path);
        while(i+1 <= nums.length-1 && nums[i]==nums[i+1] ){
            i++;
        }
        path.remove(new Integer(nums[i]));
        dfs(nums,i+1,path);
    }
}
