class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        bckt(0,nums,target,new ArrayList<>(),0);
        return res;
    }
    void bckt(int i,int[] nums,int target, List<Integer> curL,int curS){
        if(curS>target || i>= nums.length){
            return;
        }
        if(curS==target){
            res.add(new ArrayList<>(curL));
            return;
        }
        curL.add(nums[i]);
        curS += nums[i];
        bckt(i,nums,target,curL,curS);
        curL.remove(curL.size()-1);
        curS -= nums[i];
        bckt(i+1,nums,target,curL, curS);
    }
}
