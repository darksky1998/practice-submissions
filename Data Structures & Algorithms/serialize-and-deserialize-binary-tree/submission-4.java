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

    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder("");
    int i=0;
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    void dfs(TreeNode root){
        if(root==null){
            sb.append("N"+",");
            return;
        }
        sb.append(Integer.toString(root.val)+",");
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return dfs(nodes);
    }
    TreeNode dfs(String[] data){

        if(data[i].equals("N")){
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(data[i]));
        i++;
        root.left = dfs(data);
        root.right = dfs(data);
        return root;
    }
}
