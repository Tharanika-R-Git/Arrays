import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int sum = 0;
        if (nums == null || nums.length < 3) return new ArrayList<>();
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            // Skip duplicate 'i' values
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicate left/right values
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } 
                else if (sum < 0) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }
        
        return result;
    }
}
