class Solution {
    HashSet<Integer> visited = new HashSet<>();
    public boolean hasDuplicate(int[] nums) {
        for(int num : nums){
            if(visited.contains(num)){
                return true;
            }
            visited.add(num);
        }
        return false;
    }

}