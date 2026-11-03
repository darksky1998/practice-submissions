class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int r1 = 0;
        int r2 = nums[0];
        for(int i = 1; i<nums.length-1;i++){
            int temp = r2;
            r2 = Math.max(nums[i]+r1,r2);
            r1 = temp;
        }
        int rr1 = 0;
        int rr2 = nums[1];
        for(int i = 2;i<nums.length;i++){
            int temp = rr2;
            rr2 = Math.max(nums[i]+rr1,rr2);
            rr1 = temp;
        }
        return Math.max(Math.max(r1,r2),Math.max(rr1,rr2));
    }

}
