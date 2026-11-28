class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()]=true;
        for(int r = s.length()-1;r>=0;r--){
            for(String word: wordDict){
                if(r+word.length()<=s.length() &&
                    word.equals(s.substring(r,r+word.length()))&&dp[r+word.length()]==true){
                    dp[r]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
