class Solution {
    int min = Integer.MAX_VALUE;
    Map<Integer,Integer> cache = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        int res = dfs(cost,-1,cost.length);
        System.out.println(cache);
        return res;
    }
    int dfs(int[] cost,int i, int n){
        if(i==n){
            return 0;
        }
        int c=0;
        if(!cache.containsKey(i+1)){
            if(i+1<n)c=cost[i+1];else c=0;
            if(i+1<=n)
            cache.put(i+1,c+dfs(cost,i+1,n));
        }
        if(!cache.containsKey(i+2)){
            if(i+2<n)c=cost[i+2];else c=0;
            if(i+2<=n)
            cache.put(i+2,c+dfs(cost,i+2,n));
        }
        return Math.min(cache.getOrDefault(i+1,Integer.MAX_VALUE),cache.getOrDefault(i+2,Integer.MAX_VALUE));

    }
}
