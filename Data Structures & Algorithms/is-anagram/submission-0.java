class Solution {
    int[] count = new int[26];
    public boolean isAnagram(String s, String t) {
        for(int c = 0;c<s.length();c++){
            count[s.charAt(c)-'a']+=1;
        }
        for(int c = 0;c<t.length();c++){
            count[t.charAt(c)-'a']-=1;
        }
        for(int i = 0; i<26;i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    }
}
