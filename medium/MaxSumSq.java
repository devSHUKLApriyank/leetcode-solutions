import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {

        int n = nums.length;

        // Step 1: Har element ka square nikalo
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // Step 2: Squares ko sort karo
        Arrays.sort(nums);

        // Step 3: Middle index nikalo
        int mid = n / 2;

        long ans = 0;

        // Step 4: Chhote squares subtract karo
        for (int i = 0; i < mid; i++) {
            ans -= nums[i];
        }

        // Step 5: Bade squares add karo
        for (int i = mid; i < n; i++) {
            ans += nums[i];
        }

        return ans;
    }
}
