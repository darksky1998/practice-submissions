class Solution {
    public void reverseString(char[] s) {
        int l = -1;int r = -1;
        if(s.length%2==0){
            r = s.length/2;
            l = r-1;
        }else{
            l = s.length/2;
            r = l;
        }
        while(l>=0 && r<=s.length-1){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l--;
            r++;
        }

    }
}