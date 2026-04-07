class move_zeros {
    public void moveZeroes(int[] nums) {
        int j = 0; // pointer for next non-zero position

        // place all non-zeros first
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // fill remaining positions with 0
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}
