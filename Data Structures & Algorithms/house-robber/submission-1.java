class Solution {
    public int rob(int[] nums) {
        
        int rob1 = 0;
        int rob2 = nums[0];
        for(int i = 1; i<nums.length;i++){
            int temp = Math.max(rob1+nums[i],rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;


    }
}
