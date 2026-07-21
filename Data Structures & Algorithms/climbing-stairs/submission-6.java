class Solution {
    public int climbStairs(int n) {
        int d = 1;
        int c = 1;
        for(int i = n-2;i>=0;i--){
            int temp = c;
            c = c+d;
            d = temp;
        }
        return c;
    }
}
