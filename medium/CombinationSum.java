class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index,
                           int[] candidates,
                           int target,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Found a valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // No candidates left
        if (index == candidates.length) {
            return;
        }

        // Choice 1: Pick current candidate
        if (candidates[index] <= target) {
            current.add(candidates[index]);

            // Stay at the same index because we can reuse this element
            backtrack(index, candidates, target - candidates[index], current, ans);

            // Backtrack
            current.remove(current.size() - 1);
        }

        // Choice 2: Skip current candidate
        backtrack(index + 1, candidates, target, current, ans);
    }
}