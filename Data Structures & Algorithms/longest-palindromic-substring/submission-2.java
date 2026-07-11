class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int maxL = 0;
        for(int i = 0;i<s.length();i++){
            int l = i;int r = i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                int size = r-l+1;
                if(size>maxL){
                    res = s.substring(l,r+1);
                    maxL = size;
                }
                l--;
                r++;
            }
            l = i;r = i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                int size = r-l+1;
                if(size>maxL){
                    res = s.substring(l,r+1);
                    maxL = size;
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
