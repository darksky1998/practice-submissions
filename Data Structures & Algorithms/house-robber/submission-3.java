class Solution {
    public int rob(int[] nums) {
        int max0 = 0;
        int max1 = nums[0];
        for(int i = 1;i<nums.length;i++){
            int temp = max1;
            max1 = Math.max(max0+nums[i],max1);
            max0=temp;
        }
        return Math.max(max0,max1);
    }
}
