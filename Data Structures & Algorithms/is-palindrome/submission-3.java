class Solution {
    public boolean isPalindrome(String s) {
       String st = validate(s);
       System.out.println(st);
       if(st.length()%2!=0){
        int l = st.length()/2;
        int r = l;
        while(l>=0 && r<st.length()){
            if(st.charAt(l)!=st.charAt(r)){
                return false;
            }
            l--;
            r++;
        }
       }else{
        int l = (st.length()/2)-1;
        int r = l+1;
        while(l>=0 && r<st.length()){
            if(st.charAt(l)!=st.charAt(r)){
                return false;
            }
            l--;
            r++;
        }
       } 
       return true;
    }

    String validate(String s){
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i<s.length();i++){
            if(
               (s.charAt(i)>='a' && s.charAt(i)<='z')||
                (s.charAt(i)>='0' && s.charAt(i)<='9')){
                    sb.append(s.charAt(i));
                }
        }
        return sb.toString();
    }
}
