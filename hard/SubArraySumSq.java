import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[] sum;
    private long[] squareSum;
    private long[] lazy;
    private int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        squareSum = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> last = new HashMap<>();

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last.getOrDefault(nums[i], -1);

            update(1, 0, n - 1, prev + 1, i, 1);

            last.put(nums[i], i);

            ans = (ans + squareSum[1]) % MOD;
        }

        return (int) ans;
    }

    private void update(int node, int start, int end,
                        int left, int right, long val) {

        if (left > end || right < start) {
            return;
        }

        if (left <= start && end <= right) {
            apply(node, start, end, val);
            return;
        }

        push(node, start, end);

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, left, right, val);
        update(node * 2 + 1, mid + 1, end, left, right, val);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        squareSum[node] =
            (squareSum[node * 2] + squareSum[node * 2 + 1]) % MOD;
    }

    private void apply(int node, int start, int end, long val) {
        long len = end - start + 1L;

        squareSum[node] =
            (squareSum[node] + 2 * val % MOD * sum[node] % MOD
             + len % MOD * val % MOD * val % MOD) % MOD;

        sum[node] = (sum[node] + len * val) % MOD;

        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void push(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;
        long val = lazy[node];

        apply(node * 2, start, mid, val);
        apply(node * 2 + 1, mid + 1, end, val);

        lazy[node] = 0;
    }
}