class Solution {
    public int removeDuplicates(int[] nums) {
        // If nothing in array, no unique elements
        if (nums.length == 0) return 0;
        else {
            // Initialize unique element count
            int numUnique = 0;

            // Loop through all nums
            for (int i = 0; i < nums.length; i++) {
                // If the two are not the same, increment and set the next unique element
                if (nums[i] != nums[numUnique]) {
                    numUnique++;
                    nums[numUnique] = nums[i];
                }
            }

            // Return unique element count (+1 due to index offset)
            return numUnique + 1;
        }
    }
}