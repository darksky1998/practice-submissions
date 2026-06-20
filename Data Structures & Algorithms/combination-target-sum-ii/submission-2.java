class Solution {
    List<List<Integer>> res  = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),0,0);
        return res;
    }
    void dfs(int[] candidates, int target,List<Integer> cur,int i, int curSum){
        if(curSum==target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(i>=candidates.length || curSum>target){
            return;
        }
        cur.add(candidates[i]);
        dfs(candidates,target,cur,i+1,curSum+candidates[i]);
        cur.remove(cur.size()-1);
        while(i+1<candidates.length && candidates[i]==candidates[i+1]){
            i++;
        }
        dfs(candidates,target,cur,i+1,curSum);
    }
}
