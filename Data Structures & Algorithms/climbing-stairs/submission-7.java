class Solution {
    public int climbStairs(int n) {
       int t = 1;
       int s = 1;
       for(int i = n-1;i>=0;i--){
        int temp = s+t;
        t = s;
        s = temp; 
       } 
       return t;
    }
}
