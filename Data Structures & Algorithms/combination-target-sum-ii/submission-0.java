class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }
    void dfs(int[] candidates, int target, int i, int cur, List<Integer> path){
        if(cur==target){
            res.add(new ArrayList<>(path));
            return;
        }
        if(i>=candidates.length || cur>target){
            return;
        }
        path.add(candidates[i]);
        dfs(candidates, target, i+1, cur+candidates[i],path);
        path.remove(new Integer(candidates[i]));
        while(i+1<candidates.length && candidates[i]==candidates[i+1]){
            i++;
        }
        dfs(candidates, target, i+1, cur,path);
    }
}
