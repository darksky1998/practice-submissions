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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null && root.right==null) return root.val;
        dfs(root);
        return max;
    }
    int dfs(TreeNode root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftSubSum = left==Integer.MIN_VALUE ? 0 : left;
        int rightSubSum = right==Integer.MIN_VALUE ? 0 : right;
        int cur = root.val;
        max = Math.max(max,Math.max(Math.max(cur,Math.max(left,right)),Math.max(cur+leftSubSum+rightSubSum,Math.max(cur+leftSubSum,cur+rightSubSum))));
        return Math.max(cur,Math.max(cur+leftSubSum,cur+rightSubSum));
    }
}
