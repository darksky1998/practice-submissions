class Solution {
    Map<Integer,Integer> cache = new HashMap<Integer,Integer>();
    public int climbStairs(int n) {
        return dfs(n,0);
    }
    int dfs(int n,int i){
        if(i==n){
            return 1;
        }
        if(i>n){
            return 0;
        }
        if(!cache.containsKey(i+1)){
            cache.put(i+1,dfs(n,i+1));
        }
        if(!cache.containsKey(i+2)){
            cache.put(i+2,dfs(n,i+2));
        }
        return cache.get(i+1)+ cache.get(i+2);
    }
}
