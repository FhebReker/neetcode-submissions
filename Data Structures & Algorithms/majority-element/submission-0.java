class Solution {
    public int majorityElement(int[] nums) {
        // Initialize map to track number and each occurance and majority count
        HashMap<Integer, Integer> numCount = new HashMap<>();
        int majority = nums.length / 2;

        // Loop through all numbers
        for (int num : nums) {
            // Increase the occurance count for that number, then if it shows up for the majority of the array, we have our number
            numCount.put(num, numCount.getOrDefault(num, 0)+1);
            if (numCount.get(num) > majority) return num;
        }

        // Default to 0 in case
        return 0;
    }
}