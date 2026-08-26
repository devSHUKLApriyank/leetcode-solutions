class Solution {

    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(
            preorder,
            inorder,
            0,
            inorder.length - 1
        );
    }

    private TreeNode build(
        int[] preorder,
        int[] inorder,
        int left,
        int right
    ) {

        if (left > right) {
            return null;
        }

        // Current preorder element = root
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int index = left;

        while (inorder[index] != rootValue) {
            index++;
        }

        // Build left subtree
        root.left = build(
            preorder,
            inorder,
            left,
            index - 1
        );

        // Build right subtree
        root.right = build(
            preorder,
            inorder,
            index + 1,
            right
        );

        return root;
    }
}