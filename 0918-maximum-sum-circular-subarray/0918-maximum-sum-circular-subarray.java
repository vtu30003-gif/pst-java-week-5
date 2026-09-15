class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        int currMax = 0, maxSum = nums[0];
        int currMin = 0, minSum = nums[0];
        
        for (int num : nums) {
            // Standard Kadane's for Maximum Subarray Sum
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);
            
            // Inverted Kadane's for Minimum Subarray Sum
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
            
            totalSum += num;
        }
        
        // If all elements are negative, max_sum is the largest (least negative) element
        if (maxSum < 0) {
            return maxSum;
        }
        
        return Math.max(maxSum, totalSum - minSum);
    }
}