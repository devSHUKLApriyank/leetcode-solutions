class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        solve(0, nums, new ArrayList<>());

        return ans;
    }

    private void solve(int index, int[] nums, List<Integer> curr) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Take
        curr.add(nums[index]);
        solve(index + 1, nums, curr);

        curr.remove(curr.size() - 1);

        // Skip all duplicates
        while (index + 1 < nums.length &&
               nums[index] == nums[index + 1]) {
            index++;
        }

        // Don't Take
        solve(index + 1, nums, curr);
    }
}