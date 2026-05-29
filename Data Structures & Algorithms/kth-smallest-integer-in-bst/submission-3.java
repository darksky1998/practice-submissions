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
    List<Integer> list = new ArrayList<>();
    int idx=0;
    int element=0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return element;
    }
    void dfs(TreeNode root, int k){
        if(root==null || idx==-1){
            return;
        }
        dfs(root.left,k);
        list.add(root.val);
        idx++;
        if(idx==k){
            element = list.get(idx-1);
            idx=-1;
            return;

        }
        dfs(root.right,k);
    }
}
