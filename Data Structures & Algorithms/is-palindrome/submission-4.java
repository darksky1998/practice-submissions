class Solution {
    public boolean isPalindrome(String s) {
        s = convert(s);
        System.out.println(s);
        int r = -1,l=-1;
        if(s.length()%2==0){
            r = s.length()/2;
            l = r-1; 
        }else{
            r = s.length()/2;
            l = s.length()/2;
        }
        while(l>=0 && r<=s.length()-1){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l--;
            r++;
        }
        return true;
    }

    String convert(String s){
        StringBuilder sb = new StringBuilder("");
        s = s.toLowerCase();
        s.trim();
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if((c>='0' && c<='9')){
                sb.append(c);
            }
             if((c>='a' && c<='z')){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
