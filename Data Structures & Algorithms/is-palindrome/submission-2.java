class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<s.length();i++){
            if((s.charAt(i)>='A'&& s.charAt(i)<='Z')||
               (s.charAt(i)>='a'&&s.charAt(i)<='z')||
               (s.charAt(i)>='0' && s.charAt(i)<='9')){
                sb.append(s.charAt(i));
               }
        }
        String newS = sb.toString().toLowerCase();
        System.out.println(newS);
        if(newS.length()%2!=0){
            int left = newS.length()/2;
            int right = left;
            while(left>=0 && right<newS.length()){
                if(newS.charAt(left)!=newS.charAt(right)){
                    return false;
                }
                left--;
                right++;
            }
        }
        else{
            int left = (newS.length()/2)-1;
            int right = newS.length()/2;
            while(left>=0 && right<newS.length()){
                if(newS.charAt(left)!=newS.charAt(right)){
                    return false;
                }
                left--;
                right++;
            }
        }
        return true;
    }
}
