class Solution {
    public int majorityElement(int[] nums) {
        int candidate =0 , count=0;
        for(int x : nums){
            if (count == 0){
                candidate = x;
                count=count+1;
            }else{
                if(candidate==x){
                    count=count+1;
                }else{
                    count--;
                }
            }
        }
            return candidate;
        }
    }