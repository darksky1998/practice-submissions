/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean dfs(TreeNode cur, int left, int right){
        if(cur==null){
            return true;
        }
        if(!(left<cur.val && cur.val<right)){
            return false;
        }
        return (dfs(cur.left,left,cur.val) && dfs(cur.right,cur.val,right));
    }
}
