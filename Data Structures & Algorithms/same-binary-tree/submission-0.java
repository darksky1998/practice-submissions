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
    public boolean isSameTree(TreeNode p, TreeNode q) {
       Deque<TreeNode> dq = new ArrayDeque<>();
       Deque<TreeNode> dq2 = new ArrayDeque<>();
       if(p==null && q==null){
        return true;
       }else if((p==null && q!=null)||(p!=null && q==null)){
        return false;
       } else{
        if(p.val!=q.val){
            return false;
        }
        else{
            dq.offerLast(p);
            dq2.offerLast(q);
            while((dq.size()==dq2.size())&&!dq.isEmpty()){
                 List<Integer> level = new ArrayList();
                 int size = dq.size();
                while(size-->0){
                    TreeNode cur = dq.pollFirst();
                    TreeNode curq = dq2.pollFirst();
                    if(cur.left!=null && curq.left!=null
                     && cur.left.val==curq.left.val){
                        dq.offerLast(cur.left);
                        dq2.offerLast(curq.left);
                    }
                    if(cur.right!=null && curq.right!=null
                     && cur.right.val==curq.right.val){
                        dq.offerLast(cur.right);
                        dq2.offerLast(curq.right);
                    }
                    if((cur.left!=null && curq.left!=null
                     && cur.left.val!=curq.left.val)||
                     (cur.right!=null && curq.right!=null
                     && cur.right.val!=curq.right.val)
                     ){
                        return false;
                     }
                    if((cur.left==null && curq.left!=null)||
                    (cur.left!=null && curq.left==null) ||
                    (cur.right==null && curq.right!=null)||
                    (cur.right!=null && curq.right==null)){
                        return false;
                    }
                }
            }
        }
       }
       return true;
    }

}
