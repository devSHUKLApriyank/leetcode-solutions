import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet <Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        int longest = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int currentEle = num;
                int count = 1;
            while(set.contains(currentEle+1)){
            currentEle++ ;
            count++;
            }
            longest = Math.max(count,longest);
            }  
        }
        return longest;
    }
}
