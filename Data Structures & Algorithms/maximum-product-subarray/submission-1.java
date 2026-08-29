class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int n: nums){
            res = Math.max(n,res);
        }
        int curMin = 1; int curMax = 1;
        for(int n: nums){
            if(n==0){
                curMax = 1;
                curMin=1;
                continue;
            }
            int temp = n*curMax;
            curMax = Math.max(n*curMax,Math.max(n,n*curMin));
            curMin = Math.min(temp,Math.min(n,n*curMin));
            //System.out.println(n+" "+curMax+" "+curMin);
            res = Math.max(res,curMax);
        }
        return res;
    }
}
