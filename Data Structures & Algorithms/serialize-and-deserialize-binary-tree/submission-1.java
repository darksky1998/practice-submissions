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

public class Codec {

    List<String> res = new ArrayList<>();
    int idx = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return String.join(",",res);
    }
    void dfs(TreeNode root){
        if(root==null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return dfs(nodes);
    }
    TreeNode dfs(String[] nodes){
       if(idx>=nodes.length || nodes[idx].equals("N")){
            idx++;
            return null;
        }
        TreeNode cur = new TreeNode(Integer.valueOf(nodes[idx]));
        idx++;
        cur.left = dfs(nodes);
        cur.right = dfs(nodes);
        return cur;
    }
}
