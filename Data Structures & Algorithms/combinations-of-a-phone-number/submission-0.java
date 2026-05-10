class Solution {
    String[] codes = new String[10];
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
       codes[0]= "";
       codes[1] = "";
       codes[2] = "ABC";
       codes[3] = "DEF";
       codes[4] = "GHI";
       codes[5] = "JKL";
       codes[6] = "MNO";
       codes[7] = "PQRS";
       codes[8] = "TUV";
       codes[9] = "WXYZ";
       if(digits.length()==0){
        return res;
       }
       dfs(0,digits,new StringBuilder(""));
       return res;
    }
    void dfs(int i, String digits,StringBuilder sb){
        if(sb.length()==digits.length()){
            res.add(sb.toString().toLowerCase());
            return;
        }
        String st = codes[digits.charAt(i)-'0'];
        for(int c = 0;c<st.length();c++){
            sb.append(st.charAt(c));
            dfs(i+1,digits,sb);
            sb.delete(sb.lastIndexOf(st.charAt(c)+""),sb.length());
        }
    }
}
