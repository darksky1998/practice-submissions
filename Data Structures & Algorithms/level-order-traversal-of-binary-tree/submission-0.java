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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) {
            Deque<TreeNode> dq = new ArrayDeque<>();
            dq.offerLast(root);
            while (!dq.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int level_size = dq.size();
                while (level_size-- > 0) {
                    TreeNode cur = dq.pollFirst();
                    level.add(cur.val);
                    if (cur.left != null) {
                        dq.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        dq.offerLast(cur.right);
                    }
                }
                res.add(level);
            }
        }
        return res;
    }
}
