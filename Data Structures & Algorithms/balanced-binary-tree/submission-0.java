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
    boolean isBal = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBal;
    }

    int dfs(TreeNode root){
        if(root==null || isBal==false){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(Math.abs(left-right)>=2){
            isBal = false;
        }
        return 1 + Math.max(left,right);
    }

}
