class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n2 = 0;
        int n1 = cost[cost.length-1];

        for(int p = cost.length-2;p>=0;p--){
            int temp = n1;
            n1 = Math.min(cost[p]+n2,cost[p]+n1);
            n2 = temp;
        }
        return Math.min(n1,n2);
    }
}
