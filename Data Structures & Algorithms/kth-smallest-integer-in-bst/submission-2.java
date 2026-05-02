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
    Map<Integer,Integer> hmap = new HashMap<>();
    int i = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return hmap.get(k-1);
    }
    void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        hmap.put(i,root.val);
        i++;
        dfs(root.right);
    }
}
