import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> twice = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                twice.add(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }

        return twice;
    }
}