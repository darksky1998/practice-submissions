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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            res.add(dq.peekLast().val);
            while(size>0){
                TreeNode cur = dq.removeFirst();
                if(cur.left!=null){
                    dq.addLast(cur.left);
                }
                if(cur.right!=null){
                    dq.addLast(cur.right);
                }
                size--;
            }
        }
        return res;
    }
}
