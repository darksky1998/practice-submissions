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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root==null){
            return res;
        }
        dq.addLast(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer> level = new ArrayList<>();
            while(size>0){
                TreeNode cur = dq.removeFirst();
                    if(cur.left!=null){
                    dq.addLast(cur.left);
                    }
                    if(cur.right!=null){
                        dq.addLast(cur.right);
                    }
                    level.add(cur.val);
                size--;
            }
            res.add(level);
        }
        return res;
    }
}
