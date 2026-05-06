class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,new StringBuilder(""),0,0);
        return res;
    }
    void dfs(int n, StringBuilder s, int open, int close){
        if(open==close && open==n){
            res.add(s.toString());
            return;
        }
        if(open<n){
            s.append("(");
            dfs(n,s,open+1,close);
            s.deleteCharAt(s.lastIndexOf("("));
        }
        if(close<open){
            s.append(")");
            dfs(n,s,open,close+1);
            s.deleteCharAt(s.lastIndexOf(")"));
        }
    }
}
