class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        if (!check(root.left, min, root.val)) {
            return false;
        }

        if (!check(root.right, root.val, max)) {
            return false;
        }

        return true;
    }
}