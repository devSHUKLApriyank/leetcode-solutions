public class MaxSubarrayAVG {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int maxSum = windowSum;  
        for (int i = 1; i <= nums.length - k; i++) {
            windowSum = windowSum - nums[i - 1] + nums[i + k - 1];
            maxSum = Math.max(maxSum, windowSum);
        }
        return (double) maxSum / k;
    }
}
