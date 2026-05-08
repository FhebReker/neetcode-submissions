class Solution {
        public static int[] twoSum(int[] nums, int target) {
        int i = 0;

        // Create a HashMap to store the indices of the numbers
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int num : nums) {
            // Calculate the difference between the target and the current number
            int difference = target - num;

            // Check if the difference is already in the map
            if (map.containsKey(difference)) {
                 // If found, return the indices of the two numbers
                return new int[] {map.get(difference), i};
            }

            // Otherwise, add the current number and its index to the map
            map.put(num, i);
            i++;
        }

        // If no such numbers are found, return an empty array
        return new int[] {};
    }

}
