class Solution {
    public int climbStairs(int n) {
        int t = 1;
        int s = 1;
        for(int i = n-2; i>=0;i--){
            int temp = s;
            s = s+t;
            t = temp;
        }
        return s;
    }
}
