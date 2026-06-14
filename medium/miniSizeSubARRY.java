public class miniSizeSubARRY { 
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0 , sum = 0;
        int minLen = Integer.MAX_VALUE;

        for(int r = 0 ; r < nums.length; r++){
            sum += nums[r];

        while(sum>=target){
            minLen = Math.min(minLen,r-l+1);
            sum -=nums[l];
            l++;
        }
        }
         return minLen == Integer.MAX_VALUE ? 0 : minLen;
}
}
