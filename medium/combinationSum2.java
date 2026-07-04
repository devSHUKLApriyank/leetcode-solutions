class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] candidates,
                           int target,
                           int start,
                           List<Integer> curr,
                           List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate values at the same level
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            // Since array is sorted, no need to continue if current number is too large
            if (candidates[i] > target)
                break;

            curr.add(candidates[i]);

            // Move to the next index because each number can be used only once
            backtrack(candidates, target - candidates[i], i + 1, curr, ans);

            curr.remove(curr.size() - 1);
        }
    }
}