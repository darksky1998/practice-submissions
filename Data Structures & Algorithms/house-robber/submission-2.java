class Solution {
    public int rob(int[] nums) {
        int l=0;
        int r = nums[0];
        for(int i = 1;i<nums.length;i++){
            nums[i] = Math.max(l+nums[i],r);
            l = r;
            r = nums[i];
        }
        return nums[nums.length-1];
    }
}
