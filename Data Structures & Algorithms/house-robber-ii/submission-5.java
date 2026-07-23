class Solution {
    public int rob(int[] nums) {
       return Math.max(nums[0],Math.max(max(Arrays.copyOfRange(nums,0,nums.length-1)),
       max(Arrays.copyOfRange(nums,1,nums.length)))); 
    }

    int max(int[] nums){
        if(nums.length>0){
int l = 0;
        int r = nums[0];
        for(int i = 1;i<nums.length;i++){
            nums[i] = Math.max(r,l+nums[i]);
            l=r;
            r=nums[i];
        }
        return nums[nums.length-1];
        }
        return Integer.MIN_VALUE;
    }
}
