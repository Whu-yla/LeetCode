package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        levelOrderBottom(root, res, 0);
        Collections.reverse(res);
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root, List<List<Integer>> list, int height) {

        if (root == null) return null;
        if (list.size() <= height) list.add(new ArrayList<>());

        list.get(height).add(root.val);
        height++;

        levelOrderBottom(root.left, list, height);
        levelOrderBottom(root.right, list, height);

        return list;
    }
}
