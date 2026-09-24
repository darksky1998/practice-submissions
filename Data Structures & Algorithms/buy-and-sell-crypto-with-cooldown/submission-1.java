class Solution {
    HashMap<String,Integer> dp = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0,true,prices);
    }
    int dfs(int i,boolean buying, int[] prices){
        if(i>=prices.length){
            return 0;
        }
        String pattern = i+"-"+buying;
        if(dp.containsKey(pattern)){
            return dp.get(pattern);
        }
        int res=0;
        int cooldown = dfs(i+1,buying,prices);
        if(buying){
            int buy = dfs(i+1,!buying,prices)-prices[i];
            res = Math.max(buy,cooldown);
        }
        else{
             int sell = dfs(i+2,!buying,prices)+prices[i];
            res = Math.max(sell,cooldown);
        }
        dp.put(pattern,res);
        return res;
    }
}
