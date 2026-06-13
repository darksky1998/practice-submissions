class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited=new boolean[nums.length];
        dfs(nums,new ArrayList<>(),visited);
        return res;
    }

    void dfs(int[] nums, List<Integer> cur,boolean[] visited){
        if(cur.size()==nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(visited[j]==false){
                visited[j]=true;
                cur.add(nums[j]);
                dfs(nums,cur,visited);
                visited[j]=false;
                cur.remove(cur.size()-1);
            }
        }
    }
}
