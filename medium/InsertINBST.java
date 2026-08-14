class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (current != null) {
            parent = current;

            if (val < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }

        return root;
    }
}
