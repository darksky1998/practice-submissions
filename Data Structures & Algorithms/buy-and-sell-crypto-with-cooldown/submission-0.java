class Solution {
    HashMap<String,Integer> dp = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0,true,prices);
    }

    int dfs(int i,boolean buying, int[] prices){
        if(i>=prices.length){
            return 0;
        }
        if(dp.containsKey(i+"-"+buying)){
            return dp.get(i+"-"+buying);
        }
        int cooldown = dfs(i+1,buying,prices);

        if(buying){
            int buy = dfs(i+1,!buying,prices)-prices[i];
            dp.put(i+"-"+buying,Math.max(buy,cooldown));
        }else{
            int sell = dfs(i+2,!buying,prices)+prices[i];
             dp.put(i+"-"+buying,Math.max(sell,cooldown));
        }
        return dp.get(i+"-"+buying);
    }
}
