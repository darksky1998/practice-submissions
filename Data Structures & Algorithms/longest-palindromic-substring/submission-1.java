class Solution {
    int max=-1;
    String maxS = "";
    public String longestPalindrome(String s) {
        for(int i = 0;i<s.length();i++){
            int left = i;
            int right = i;
            while(left>=0 && right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    if((right-left+1)>=max){
                        max=right-left+1;
                        maxS = s.substring(left,right+1);
                    }
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }
        }
        for(int i = 0;i<s.length();i++){
            int left = i;
            int right = i+1;
            while(left>=0 && right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    if((right-left+1)>=max){
                        max=right-left+1;
                        maxS = s.substring(left,right+1);
                    }
                    left--;
                    right++;
                }else{
                    break;
                }
            }
        }
        return maxS;
    }
}
