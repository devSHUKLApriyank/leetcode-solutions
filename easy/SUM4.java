class Solution {
    public boolean findTarget(TreeNode root, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        inorder(root, list);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            int sum = list.get(left) + list.get(right);

            if (sum == k) {
                return true;
            }
            else if (sum < k) {
                left++;
            }
            else {
                right--;
            }
        }

        return false;
    }

    private void inorder(TreeNode root, ArrayList<Integer> list) {

        if (root == null) {
            return;
        }

        inorder(root.left, list);

        list.add(root.val);

        inorder(root.right, list);
    }
}