class Solution {
    public int rob(int[] nums) {
        int n0 = 0;
        int n1 = nums[0];
        
        for(int i = 1; i<nums.length;i++){
           int temp = n1;
           n1 = Math.max(nums[i]+n0,n1);
           n0 = temp;
        }
        return Math.max(n1,n0);
    }
}
