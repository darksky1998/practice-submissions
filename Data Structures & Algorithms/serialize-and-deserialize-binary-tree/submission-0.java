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
    int idx = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       return String.join(",",dfs(root,new ArrayList<String>()));
    }

    List<String> dfs(TreeNode cur, List<String> res){
        if(cur==null){
             res.add("N");
             return res;
        }
        res.add(String.valueOf(cur.val));
        res = dfs(cur.left,res);
        res = dfs(cur.right,res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return dfs(nodes);
    }
    TreeNode dfs(String[] nodes){
        if(nodes[idx].equals("N")){
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
