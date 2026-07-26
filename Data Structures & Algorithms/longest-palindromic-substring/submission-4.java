class Solution {
    int len = Integer.MIN_VALUE;
    String max = "";
    public String longestPalindrome(String s) {
        for(int i = 0;i<s.length();i++){
            int l = i;
            int r = i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>len){
                    len = (r-l+1);
                    max = s.substring(l,r+1);
                }
                l--;
                r++;
            }
            l = i;
            r = i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>len){
                    len = (r-l+1);
                    max = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return max;
    }
}
