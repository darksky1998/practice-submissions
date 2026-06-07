class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] pick = new boolean[nums.length];
        dfs(nums,new ArrayList<>(),pick);
        return res;
    }
    void dfs(int[] nums, List<Integer> perm, boolean[] pick){
        if(perm.size()==nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!pick[i]){
                pick[i]=true;
                perm.add(nums[i]);
                dfs(nums,perm,pick);
                pick[i]=false;
                perm.remove(perm.size()-1);
            }
        }
    }
}
