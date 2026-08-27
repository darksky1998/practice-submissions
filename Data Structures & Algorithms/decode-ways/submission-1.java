class Solution {
    Map<Integer,Integer> dp = new HashMap<>();
    public int numDecodings(String s) {
        dp.put(s.length(),1);
        return dfs(0,s);
    }

    int dfs(int i,String s){
        if(dp.get(i)!=null){
            return dp.get(i);
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        int res = dfs(i+1,s);
        if((i+1)<s.length() && ((s.charAt(i)=='2' && s.charAt(i+1)>='0' && s.charAt(i+1)<='6') || s.charAt(i)=='1')){
            res += dfs(i+2,s);
        }
        dp.put(i,res);
        return res;
    }
}
