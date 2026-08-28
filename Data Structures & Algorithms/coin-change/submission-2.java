class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int a = 1; a<=amount;a++){
            for(int c = 0; c<coins.length;c++){
                if(a-coins[c]>=0){map.put(a,Math.min(map.getOrDefault(a,amount+1),1+map.getOrDefault(a-coins[c],amount+1)));
                }
            }
        }
        if(map.getOrDefault(amount,amount+1)==amount+1){
            return -1;
        }
        return map.get(amount);
    }
}
