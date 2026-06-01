class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<>());
        return res;
    }

    void dfs(String s, int i, List<String> cur){
    if(i>=s.length()){
        res.add(new ArrayList<>(cur));
        return;
    }
    for(int j = i;j<s.length();j++){
        if(isPalin(s,i,j)){
            cur.add(s.substring(i,j+1));
            dfs(s,j+1,cur);
            cur.remove(cur.size()-1);
        }
    }

    }

    boolean isPalin(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;r--;
        }
        return true;
    }

}
