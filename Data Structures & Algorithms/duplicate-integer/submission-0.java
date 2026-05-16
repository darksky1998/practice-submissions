class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean hasDuplicate(int[] nums) {
        for(int n : nums){
            if(set.contains(n)){
                return true;
            }
            set.add(n);
        }
        return false;
    }
}